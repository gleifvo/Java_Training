package se02.task5;

public enum Discipline {
	Mathematics(Double.class), Physics(Double.class), Russian(Integer.class);

	
	Class<? extends Number> dicsiplineType;

	public Class<? extends Number>  getDicsiplineType() {
		return dicsiplineType;
	}

	private Discipline(Class<? extends Number>  dicsiplineType) {
		this.dicsiplineType = dicsiplineType;
	}


	
	
}
