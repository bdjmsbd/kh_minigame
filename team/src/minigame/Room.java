package minigame;

import lombok.Data;

@Data
public class Room {

	// 두 명의 사용자 관리
	private ConnectedUser roomManager; // 방장
	private ConnectedUser player; // 참여한 플레이어

	// 게임 객체 생성
	private Baseball baseball;
	private Omok omok;
	// .. private otherGame otherGame

	private String isPlaying = Type.start;
	private String gameTitle;
	private String roomTitle;

	public Room(ConnectedUser roomManager, String roomTitle, String gameTitle) {

		this.roomManager = roomManager;
		this.gameTitle = gameTitle;
		this.roomTitle = roomTitle;
	}

	public String getCurrentTurn() {
		String msg = "";

		switch (gameTitle) {
			case Type.baseBall:
				msg = baseball.getCurrentTurn();
				break;
				// case Tag.otherGame :
			case Type.omok:
				msg = omok.getCurrentTurn();
				break;
		}
		return msg;
	}
	
	public String getLoser() {
		String msg = null;

		switch (gameTitle) {
			case Type.baseBall:
				msg = baseball.getLoser();
				break;
				// case Tag.otherGame :
			case Type.omok:
				msg = omok.getLoser();
				break;
		}
		return msg;
	}
	
	public String getWinner() {
		String msg = null;

		switch (gameTitle) {
			case Type.baseBall:
				msg = baseball.getWinner();
				break;
				// case Tag.otherGame :
			case Type.omok:
				msg = omok.getWinner();
				break;
		}
		return msg;
	}

	// 게임을 통괄하는 메소드
	// start, playing, end로 나눠서
	// 처음 시작시, 중간 플레이 과정, 승패 결과로 나뉨
	public Message gameRun(Message message) {

		Message tmp = new Message();

		switch (gameTitle) {
			case Type.baseBall:

				if (isPlaying.equals(Type.start)) {
					// 게임 첫 시작.
					isPlaying = Type.playing;
				} else {
					baseball.run(message);
				}
				tmp.setMsg(baseball.getResult());
				break;
			case Type.omok:
//				게임 이닛, 차례 정하고 초기화면 받기
				if (isPlaying.equals(Type.start)) {
					// 게임 첫 시작.
					isPlaying = Type.playing;
				} else {
					omok.run(message);
				}
				tmp.setMsg(omok.getResult());
				break;

//			case Tag.otherGame:
//				break;

		}
		return tmp;
	}

	public void gameInit() {
		// 게임 객체 생성
		// 객체는 방장, 플레이어 두 객의 닉네임 정도만 간단하게 받음(가안)

		switch (gameTitle) {
			case Type.baseBall:
				baseball = new Baseball(roomManager.getUser().getId(),
						player.getUser().getId());
				break;
			case Type.omok:
				omok = new Omok(roomManager.getUser().getId(),
						player.getUser().getId());
				break;
		}

	}

	@Override
	public String toString() {
		return "[" + gameTitle + "]" + " " + roomTitle + " <방장:"
				+ roomManager.getUser().getId() + ">";
	}



}