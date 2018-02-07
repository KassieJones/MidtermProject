public enum BookStatus {

	AVAILABLE, UNAVAILABLE;


	public String toString() {
		switch(this) {
		case AVAILABLE:
			return "Available";
		case UNAVAILABLE:
			return "Unavailable";
		}
		return super.toString();
	}

}