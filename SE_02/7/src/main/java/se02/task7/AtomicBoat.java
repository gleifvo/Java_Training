package se02.task7;

@AtomicInfo(crew = 5000, owner = "USA")
public class AtomicBoat {

	private boolean inMove = false;

	private EngineAtomicBoat enigneAtomicBoat = new EngineAtomicBoat();

	public boolean isInMove() {
		return inMove;
	}

	@AtomicState(inMove = true)
	public String runAtomicBoat() {
		this.enigneAtomicBoat.Start();

		this.inMove = enigneAtomicBoat.isEnable();

		return "Boat is moving!!";

	}

	private class EngineAtomicBoat {

		private boolean enable = false;

		public void Start() {

			this.enable = true;
		}

		public boolean isEnable() {
			return enable;
		}
	}

}
