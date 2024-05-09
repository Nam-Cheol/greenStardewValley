package stardewValley.A_OHJ;

//TODO 야채에 대한 기능 및 속성
public interface vegetable {

	void initData();

	void setInitLayout();

	void grow();

	void harvest();

	void sprinkling(int water);
}
