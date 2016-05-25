package Game3;

import java.awt.event.MouseEvent;
import java.util.Random;
import OverallGame.Controller;
import OverallGame.MiniGame;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Game3 is a game where the objective is to count how many Horseshoe Crabs pass by the screen. It resembles the real life
 * scenario of a Horseshoe Crab spawning survey.
 * For each Horseshoe Crab seen, click the mouse to increase the counter.
 * After all the Animals have come and went, it will display the player's count estimate and the real count, adding score accordingly.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game3 extends MiniGame {
	Random rand = new Random();
	public Game3View view;
	static boolean inst;
	long startTime;
	long timer2;
	int mx,my;
	boolean endGameScreen;
	boolean spawn;
	boolean start;
	int tick;
	int animals;
	int actNumCrab;
	int clickNumCrab;
	
	/**
	 * Constructor for Game3 objects
	 */
	public Game3(){
		view = new Game3View();
	}
	
    /**
     * When the mouse button is pressed, increments clickNumCrab and sets mx/my to the mouse's x and y position.
     * If the mouse was over the quit button when pressed, reset the game.
     */
	public void mousePressed(MouseEvent e){
		mx = e.getX();
		my = e.getY();
		
		if(inst && mouseOver(mx,my,scaleW(570),scaleH(520),scaleW(111),scaleH(52)))
				inst = false;
		else{
			if(!endGameScreen)
				clickNumCrab++;	
		}
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44))){
			endGame();
			if(endGameScreen)
				addScore();
		}

	}

	/**
	 * Updates the animals in the ArrayList of gameObjects.
	 * Makes animal move and if the animal' name is "Count", sets it's x position to the value of clickNumCrab.
	 * If the animal is on the screen and outside the screen boundaries, and the name of it is "HorseShoe", increment actNumCrab, then 
	 * increment animals and set it's onScreen value to false.
	 * If it's name is not "HorseShoe", just increment animals and set it's onScreen value to false. 
	 */
	void updateAnimal(){
		Animal a;
		for(gameObject o:objects){
			a = (Animal)(o);
			if(a.name == "Count")
				a.setX(clickNumCrab);
			else{
				if(!spawn){
					a.setX(a.getX()+a.getVelx());
					a.setY(a.getY()+a.getVely());	
				}
				a.setX(a.getX()+a.getVelx());
				a.setY(a.getY()+a.getVely());
			}
			if(a.onScreen &&( a.getX()<0 || a.getX()>Window.WIDTH*Window.SCALE || a.getY()<0 || a.getY() > Window.HEIGHT*Window.SCALE)){
				a.onScreen = false;
				animals++;
			}
		}
	}
	
	/**
	 * Creates a random animal object
	 * 
	 * @param Enemy whether the animal is an enemy or not.
	 * @param speed speed of the animal being created.
	 * @param Amount amount of animal objects to be created.
	 */
	public void randSpawn(int Amount){
		Random rand = new Random();
		Direction dir = Direction.N;
		String name = "";
		for(int i = 0;i < Amount;i++){
			int speed = rand.nextInt(2)+1;//random speed
			int rAnim = rand.nextInt(3);//random Animal
			int d = rand.nextInt(3);//random direction
			int tRand = rand.nextInt(6);
			int x=0,y=0,velx=0,vely=0;
			
			if( rAnim == 1)
				name = "bluecrab_0";
			else if(rAnim == 2)
				name = "mittencrab_1";
			else
			    name = "HorseShoe";
			if(tRand<2){//spawn left or right
				y = rand.nextInt(280)+250;
				if(rand.nextBoolean()){//spawn left
					x = 0;
					velx = 2*speed;
					if( d== 0){
						dir = Direction.NE;
						vely = -1;
					}else if(d == 1){
						dir = Direction.SE;
						vely = 1;
					}else{
						vely = 0;
						dir = Direction.E;
					}
				}else{//spawn right
					x = Window.WIDTH;
					velx = -2*speed;
					if( d== 0){
						dir = Direction.NW;
						vely = -1;
					}else if(d == 1){
						dir = Direction.SW;
						vely = 1;
					}else{
						vely = 0;
						dir = Direction.W;
					}
				}
			}else{//spawn top or bottom
				x = rand.nextInt(425)+425;
				if(rand.nextBoolean()){//spawn top
					y = 0;
					vely = 1*speed;
					if( d== 0){
						dir = Direction.SW;
						velx = -1*speed;
					}else if(d == 1){
						dir = Direction.SE;
						velx = 1*speed;
					}else{
						velx = 0;
						dir = Direction.S;
					}
				}else{//spawn bottom
					y = Window.HEIGHT;
					vely = -1*speed;
					if( d== 0){
						dir = Direction.NW;
						velx = -1*speed;
					}else if(d == 1){
						dir = Direction.NE;
						velx = 1*speed;
					}else{
						velx = 0;
						dir = Direction.N;
					}
				}
			}
			if(name == "HorseShoe"){
				actNumCrab++;
			}
			objects.add(new Animal(name,x,y,velx,vely,dir));
		}
	}
	

	/**
	 * Checks to see if it is the end of the game and handles the score gained from the game depending on how close
	 * the player count of horseshoe crabs was to the actual count. Adds horseshoe crabs if the game isn't over.
	 */
	private void checkEndGame(){
		if(System.currentTimeMillis() > startTime+15000.0){
			spawn = false;
			if(endGameScreen){
				if (System.currentTimeMillis() > timer2+2500){
					addScore();
					endGame();
				}
			} else if(objects.size() == animals+1){
				timer2 = System.currentTimeMillis();
				objects.add(new Animal("EndGame",actNumCrab,clickNumCrab,0,0, null));
				endGameScreen = true;
			}
		}
	}
	
	/**
	 * Resets the game by setting the game variables to their starting values and sets the gameState back to the Menu
	 */
	
	public void initialize(){
		startTime = System.currentTimeMillis();
		inst = true;
		spawn = true;
		endGameScreen = false;
		start = false;
		running = true;
		animals = 0;
		actNumCrab = 0;
		clickNumCrab = 0;
		objects.clear();
		objects.add(new Animal("Count",0,0,0,0,null));
		tick = 0;
	}
	
	public void endGame(){
		running = false;
		Controller.gameState = STATE.Menu;
	}
	
	public void addScore(){
		if(actNumCrab-clickNumCrab == 0){
			Menu.Menu.SCORE += 100;
		}else if(actNumCrab-clickNumCrab == 1 || clickNumCrab-actNumCrab == 1){
			Menu.Menu.SCORE += 75;
		}else if(actNumCrab-clickNumCrab == 2 || clickNumCrab-actNumCrab == 2){
			Menu.Menu.SCORE += 50;
		}
	}

	/**
	 * Handles what methods are called on each tick of the game.
	 * If start is not true, add a new animal and set start to true, otherwise call checkEndGame and updateAnimal
	 */
	public void tick() {
		if(!inst){
			checkEndGame();
			if(tick%30 == 0 && spawn)
				randSpawn(rand.nextInt(2));
			updateAnimal();
			tick++;
		}else{
			startTime = System.currentTimeMillis();
		}
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public int getTick() {
		return tick;
	}

	public void setTick(int tick) {
		this.tick = tick;
	}

	public int getAnimals() {
		return animals;
	}

	public void setAnimals(int animals) {
		this.animals = animals;
	}

	public int getActNumCrab() {
		return actNumCrab;
	}

	public void setActNumCrab(int actNumCrab) {
		this.actNumCrab = actNumCrab;
	}

	public int getClickNumCrab() {
		return clickNumCrab;
	}

	public void setClickNumCrab(int clickNumCrab) {
		this.clickNumCrab = clickNumCrab;
	}

	Random getRand() {
		return rand;
	}

	void setRand(Random rand) {
		this.rand = rand;
	}

	Game3View getView() {
		return view;
	}

	void setView(Game3View view) {
		this.view = view;
	}

	static boolean isInst() {
		return inst;
	}

	static void setInst(boolean inst) {
		Game3.inst = inst;
	}

	long getStartTime() {
		return startTime;
	}

	void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	long getTimer2() {
		return timer2;
	}

	void setTimer2(long timer2) {
		this.timer2 = timer2;
	}

	int getMx() {
		return mx;
	}

	void setMx(int mx) {
		this.mx = mx;
	}

	int getMy() {
		return my;
	}

	void setMy(int my) {
		this.my = my;
	}

	boolean isEndGameScreen() {
		return endGameScreen;
	}

	void setEndGameScreen(boolean endGameScreen) {
		this.endGameScreen = endGameScreen;
	}

	boolean isSpawn() {
		return spawn;
	}

	void setSpawn(boolean spawn) {
		this.spawn = spawn;
	}
	
	
}