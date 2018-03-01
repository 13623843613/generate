package cn.org.rapid_framework.generator;

/**
 * @author
 * @email
 */

public class GeneratorMain {
    /**
     * 请直接修改以下代码调用不同的方法以执行相关生成任务.
     */
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        genTables(g);
//		 genAllTables(g);

        System.out.println("《======================Generator SUSSCESS==============================》");
    }

    private static void genAllTables(GeneratorFacade g) throws Exception {
        g.generateByAllTable("template");
    }

    private static void genTables(GeneratorFacade g) throws Exception {
        String[] tableNames = GeneratorMain.getValuesBase1();
        for (String tableName : tableNames) {
            g.generateByTable(tableName, "template");// 通过数据库表生成文件,template为模板的根目录
        }
    }

    private static String[] getValuesBase1() {
        String[] tableNames = {"wzry_hero"};
        return tableNames;
    }


}