package core;

import util.db.DBConn;

// 메인 컨트롤러 시작 및 환경 설정들 초기화, 해제
public class TechInterviewHelperMainThread extends Thread {

    private DispatchController dispatchController;
    private DBConn dbConn;

    @Override
    public void run() {
        initSystemConfiguration();
        dispatchController.start();
        closeSystemConfiguration();
    }

    public void initSystemConfiguration() {
        dbConn = DBConn.getInstance();
        dbConn.initDB("oracle", "src/main/resources/oracleDBinfo.propertise");
//        dbConn.initDB("h2", "src/main/resources/h2DBinfo.propertise");
        dispatchController = new DispatchController();
    }

    public void closeSystemConfiguration() {
        dbConn.closeDB();
    }
}
