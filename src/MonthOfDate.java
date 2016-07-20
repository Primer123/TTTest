

public enum MonthOfDate {
	Jan("01"),Feb("02"),Mar("03"),Apr("04"),May("05"),Jun("06"),Jul("07"),Aug("08"),Sep("09"),Oct("10"),Nov("11"),Dec("12"){
		@Override
        public boolean isRest() {
            return true;
        }
	};
	
	private String value;
	 
    private MonthOfDate(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
 
    public boolean isRest() {
        return false;
    }
}
