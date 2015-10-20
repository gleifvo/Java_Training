package se02.task6;

public class AtomicBoat {

	private boolean inMove = false;

	private EngineAtomicBoat enigneAtomicBoat = new EngineAtomicBoat();

	public boolean isInMove() {
		return inMove;
	}

	public String runAtomicBoat() {
		this.enigneAtomicBoat.Start();

		this.inMove = true;

		return "Boat is moving!!";
	}

	private class EngineAtomicBoat {

		private boolean enable = false;

		public void Start() {

			this.enable = true;
		}

	}

}