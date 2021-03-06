<#assign className = table.className>   
<#assign classNameLowerCase = className?lower_case>
<#assign classNameFirstLower = table.classNameFirstLower>   
$(function () {
	//JY.Dict.setSelect("selectRegionalCenter,selectInternationalTelephone,selectInternationalPhone","usStates,international,international",2,"请选择",null);
	getbaseList();
	//增加回车事件
	$("#baseForm").keydown(function(e){
		 keycode = e.which || e.keyCode;
		 if (keycode==13) {
			 search();
		 } 
	});
	//功能按钮新加
	$('#addBtn').on('click', function(e) {
		//通知浏览器不要执行与事件关联的默认动作	
		e.preventDefault();
		cleanForm();	
		JY.Model.edit("centerDiv","新增信息",function(){
			 if(JY.Validate.form("${classNameFirstLower}Form")){
				 var that =$(this);
				 $("#${classNameFirstLower}Form").ajaxSubmit({  
					 	url:  jypath + "/${classNameFirstLower}/add",   
				        type: 'post',  
				        success: function(data){  
				        	  that.dialog("close");      
		     				  JY.Model.info(data.resMsg,function(){search();}); 
				        }
				    });  
			 }	
		},null,"84%");
	});

//批量删除
	$('#delBatchBtn').on('click', function(e) {
		//通知浏览器不要执行与事件关联的默认动作		
		e.preventDefault();
		var chks =[];    
		$('#baseTable input[name="ids"]:checked').each(function(){    
			chks.push($(this).val());    
		});     
		if(chks.length==0) {
			JY.Model.info("您没有选择任何内容!"); 
		}else{
			JY.Model.confirm("确认要删除选中的数据吗?",function(){	
				JY.Ajax.doRequest(null,jypath +'/${classNameFirstLower}/delBatch',{chks:chks.toString()},function(data){
					JY.Model.info(data.resMsg,function(){search();});
				});
			});		
		}		
	});
});
function search(){
	$("#searchBtn").trigger("click");
}
var preisShow=false;//窗口是否显示
function getbaseList(init){
	if(init==1)$("#baseForm .pageNum").val(1);	
	JY.Model.loading();
	JY.Ajax.doRequest("baseForm",jypath +'/${classNameFirstLower}/findByPage',null,function(data){
		 $("#baseTable tbody").empty();
		 	 var obj=data.obj;
		 	 var list=obj.list;
		 	 var results=list.results;
		 	 console.info(data);
		 	 var permitBtn=obj.permitBtn;
         	 var pageNum=list.pageNum,pageSize=list.pageSize,totalRecord=list.totalRecord;
        	 var html="";
    		 if(results!=null&&results.length>0){
        		 var leng=(pageNum-1)*pageSize;//计算序号
        		 for(var i = 0;i<results.length;i++){
            		 var l=results[i];     
            		 /*html+="<td class='center'><label> <input type='checkbox' name='ids' value='"+l.id+"' class='ace' /> <span class='lbl'></span></label></td>";
            		 html+="<td class='center hidden-480'>"+(i+leng+1)+"</td>";*/
            		 html+="<tr>";
            		 <#list table.columns as column>
            		 html+="<td class='center'>"+JY.Object.notEmpty(l.${column.columnNameLower})+"</td>";
            		</#list>
            		html+=JY.Tags.setFunction(l.id,permitBtn);
            		html+="</tr>";		 
            	 } 
        		 $("#baseTable tbody").append(html);
        		 JY.Page.setPage("baseForm","pageing",pageSize,pageNum,totalRecord,"getbaseList");
        	 }else{
        		html+="<tr><td colspan='10' class='center'>没有相关数据</td></tr>";
        		$("#baseTable tbody").append(html);
        		$("#pageing ul").empty();//清空分页
        	 }	
    		 JY.Model.loadingClose();
	 });
}

function check(id){
	cleanForm();
	JY.Ajax.doRequest(null,jypath +'/${classNameFirstLower}/findInfo',{id:id},function(data){
		//JY.Dict.setSelect("selectInternationalTelephone","international",2,"请选择国家",data.obj.telephoneType);
	    setForm(data);
	    JY.Model.check("centerDiv",null,null,"84%");       
	});
}

function del(id){
	JY.Model.confirm("确认删除吗？",function(){	
		JY.Ajax.doRequest(null,jypath +'/${classNameFirstLower}/delete',{id:id},function(data){
			JY.Model.info(data.resMsg,function(){search();});
		});
	});
}
function edit(id){
	cleanForm();
	JY.Ajax.doRequest(null,jypath +'/${classNameFirstLower}/findInfo',{id:id},function(data){
		//JY.Dict.setSelect("selectInternationalTelephone","international",2,"请选择国家",data.obj.telephoneType);
	    setForm(data);   
	    JY.Model.edit("centerDiv","修改",function(){
	    	if(JY.Validate.form("${classNameFirstLower}Form")){
	    		 var that =$(this);
				 $("#${classNameFirstLower}Form").ajaxSubmit({  
					 	url:  jypath + "/${classNameFirstLower}/update",   
				        type: 'post',  
				        success: function(data){  
				        	  that.dialog("close");      
		     				  JY.Model.info(data.resMsg,function(){search();}); 
				        }
				    }); 
			}	
	    },null,"84%");
	});
}
function cleanForm(){
	JY.Tags.cleanForm("${classNameFirstLower}Form");
	//$("#${classNameFirstLower}Form input[name$='id']").val('');
}
function setForm(data){
	var l=data.obj;
	 <#list table.columns as column>
	 $("#${classNameFirstLower}Form input[name$='${column.columnNameLower}']").val(JY.Object.notEmpty(l.${column.columnNameLower}));
	</#list>
}
