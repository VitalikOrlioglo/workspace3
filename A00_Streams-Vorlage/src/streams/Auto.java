package streams;

class Auto {
	enum Marke{BMW,MERCEDES,OPEL,ENTE,FORD};
	private int geschwindigkeit;
	private String farbe;
	private Marke marke;

	public Auto(int geschwindigkeit, String farbe, Marke marke) {
		this.geschwindigkeit = geschwindigkeit;
		this.farbe = farbe;
		this.marke = marke;
		
	}

	public Marke getMarke() {
		return marke;
	}

	public void setMarke(Marke marke) {
		this.marke = marke;
	}

	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}

	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	@Override
	public String toString() {
		return "Auto [geschwindigkeit=" + geschwindigkeit + ", farbe=" + farbe + ", marke=" + marke + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((farbe == null) ? 0 : farbe.hashCode());
		result = prime * result + geschwindigkeit;
		result = prime * result + ((marke == null) ? 0 : marke.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (farbe == null) {
			if (other.farbe != null)
				return false;
		} else if (!farbe.equals(other.farbe))
			return false;
		if (geschwindigkeit != other.geschwindigkeit)
			return false;
		if (marke != other.marke)
			return false;
		return true;
	}



}