package se02.task1;

public class Pen {

	private Ink ink;

	private PenMaterial penMaterial;

	public Ink getInk() {
		return ink;
	}

	public PenMaterial getPenMaterial() {
		return penMaterial;
	}

	public Pen(Ink ink, PenMaterial penMaterial) {
		this.ink = ink;
		this.penMaterial = penMaterial;
	}

	public Pen() {
		this.ink = Ink.BLUE;
		this.penMaterial = PenMaterial.PLASTIC;
	}

	public void setInk(Ink ink) {
		this.ink = ink;
	}

	public void setPenMaterial(PenMaterial penMaterial) {
		this.penMaterial = penMaterial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ink == null) ? 0 : ink.hashCode());
		result = prime * result + ((penMaterial == null) ? 0 : penMaterial.hashCode());
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
		Pen other = (Pen) obj;
		if (ink != other.ink)
			return false;
		if (penMaterial != other.penMaterial)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pen [ink=" + ink + ", penMaterial=" + penMaterial + "]";
	}

}
