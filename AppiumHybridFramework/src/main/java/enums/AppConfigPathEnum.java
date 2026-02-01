package enums;

public enum AppConfigPathEnum {

	App_CONFIG_PATH("./src/main/resources/AppConfig.properties"),
	APP_PACKAGE(".appPackage"), APP_ACTIVITY(".appActive"),
	USER_NAME(".userNumber"),USER_PASSWORD(".userPassword");
	
	String configPathData;
	
	AppConfigPathEnum(String configPathData) {
		this.configPathData = configPathData;
	}
	
	public String appConfigPathReader() {
		return configPathData;
	}
}
