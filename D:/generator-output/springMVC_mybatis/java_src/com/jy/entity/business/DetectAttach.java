
package com.jy.entity.business;  
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DetectAttach  implements Serializable{
	
    /**
     * 主键
     */
    private String id; 
    /**
     * 维修ID
     */
    private String repairId; 
    /**
     * 责任险（1：意外 2：翻新  2：延保）
     */
    private String dutyType; 
    /**
     * 保险类型（1：保内 2：保外）
     */
    private String insureType; 
    /**
     * 备件名称
     */
    private String spareName; 
    /**
     * 备件金额
     */
    private Long spareMoney; 
    /**
     * 图片名
     */
    private String picName; 
    /**
     * 图片URL
     */
    private String picUrl; 
    /**
     * 备注
     */
    private String remark; 
}
