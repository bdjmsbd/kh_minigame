package 윤호.test;

public class SpeedQuiz {
	public static SpeedQuiz[] sqList = {
			new SpeedQuiz("대한민국 1세대 리그 오브 레전드 팀 중 하나인 CJ 엔투스 프로스트 멤버 중 1명으로 "
					+ " 판단력과 적절한 드립, 포장 등 뛰어난 실력으로 10년 이상 꾸준히 해설가는 누구일까?","클라우드템플러","클템","이현우","클라우드 템플러"),
			new SpeedQuiz("1982년생 가수이며 안동 장씨이다. 2008년 밴드로 데뷔했으며 현재까지도 꾸준히 앨범을 출시하고있다. 해당 가수의 이름은?","장기하"),
			new SpeedQuiz("뜻이 맞는 사람들이 모여 목적을 달성하기 위해 맴세하는 뜻으로"
					+ "복숭아 나무 밑에서 유비,관우, 장비가 의형제를 맺은것에 유래된 고사성어는 무엇일까","도원결의"),
			new SpeedQuiz("인재를 맞아들이기 위해 노력하거나 마음을 쓴다는 뜻으로"
					+ " 유비가 제갈량을 얻기위해 초가집을 세번이나 찾아간 일화에서 유래된 고사성어는 무엇일까","삼고초려")
	};
	
	public String problem;
	public String[] answer;
	
	public SpeedQuiz(String problem, String... answer) {
		this.problem = problem;
		this.answer = answer;
	}
}
