import java.util.Scanner;

/**
 *
 * Gale-Shapley �A���S���Y��
 * (���茋�����)
 *
 * �A���S���Y��
 * 1. �N�ɂ��L�[�v����Ă��Ȃ��j��1�l���A(���܂Ńt����Ă��Ȃ�����)��Ԍ��������������ɍ�������B
 * 2. �������󂯂������́A
 * �@�@��: ���肪���Ȃ� or ���L�[�v���Ă���l�����悢����Ȃ獐�����Ă����l���L�[�v����
 * �@�@�@�@�@(���܂ŃL�[�v���Ă��l�Ƃ͂���Ȃ炷��)
 * �@�@����: ���L�[�v���Ă���l�̕����悢�Ȃ獐����f��
 * 3. 1,2 ���J��Ԃ��A�S�j�����N������ɃL�[�v���ꂽ�炻�̎��_�̃y�A(���S�}�b�`���O)������
 *
 * �Q�l
 * http://mathtrain.jp/galeshapley
 *
 * �g���ŃA���S���Y��(�����l�Ή���)
 * 1. �j���̍ő�L�[�v���܂Œj�����������L�[�v���Ă��Ȃ��ꍇ�A
 * �@�@���܂Ńt����Ă��Ȃ��A�L�[�v���Ă�l�ł͂Ȃ��l�ŁA��Ԍ��������������ɍ�������B
 * 2. �������󂯂������́A
 * �@�@��: �����̍ő�L�[�v���܂Œj�����L�[�v���Ă��Ȃ��@or
 * �@�@�@�@�@�@�����̍ő�L�[�v���܂Œj�����L�[�v���Ă��邪�A�L�[�v���Ă���j���̍Œ�(��ԗD��x���Ⴂ�l)����
 * �@�@�@�@�@�@�@���z������(�D��x������)�l���������Ă�����A�������Ă����l���L�[�v����
 * �@�@�@�@�@�@�@�@(�L�[�v���Ă����Œ�̐l�Ƃ���Ȃ炷��)
 * �@�@����: ���L�[�v���Ă���S���ɍ������Ă����l����l�����ĂȂ��Ȃ�f��
 *  3. 1,2 ���J��Ԃ��A�S�j�����ő�L�[�v���܂ŃL�[�v���ł����炻�̎��_�Ńy�A(���S�}�b�`���O)������
 *
 * @author koike
 * @since 2015.10.16
 * @version 2
 *
 * memo 180min
 *
 * ���̓T���v���͈ȉ�

 �y�e�X�g1����: 3:3 �ŃL�[�v1�z
 ������
 3
 3
 2 0 1
 2 1 0
 0 2 1
 0 1 2
 2 0 1
 2 1 0
 1
 1
 ���o��
 blue 0 �̍���, 0�l�̓L�[�v��
 blue 0 �� 0 �Ԗڌ�� 2 (red����� 2 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 1 �̍���, 0�l�̓L�[�v��
 blue�� 0 ���� 0 �Ԗڌ��ł���red 2 ���񂩂�L�[�v����
 blue 1 �� 0 �Ԗڌ�� 2 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���ǂ�)
 blue 0 �̍���, 0�l�̓L�[�v��
 blue 0 �� 1 �Ԗڌ�� 0 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 2 �̍���, 0�l�̓L�[�v��
 blue 2 �� 0 �Ԗڌ�� 0 �ɍ�����f��
 blue 2 �̍���, 0�l�̓L�[�v��
 blue�� 1 ���� 0 �Ԗڌ��ł���red 2 ���񂩂�L�[�v����
 blue 2 �� 1 �Ԗڌ�� 2 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���ǂ�)
 blue 1 �̍���, 0�l�̓L�[�v��
 blue 1 �� 1 �Ԗڌ�� 1 (red����� 2 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 --- blue ---
 blue 0 : 0,
 blue 1 : 1,
 blue 2 : 2,

 --- red ---
 red 0 : 0,
 red 1 : 1,
 red 2 : 2,

 �y�e�X�g2����: 6:4 �ŃL�[�v2:3�z
 ���Q�l
 ���Z�@�@�@�@�@�@�@�@�@�@�@��w
 a>b>c>d�@�P�@a�@1>2>3>4>5>6
 b>c>a>d�@�Q�@b�@6>5>4>3>2>1
 c>d>a>b�@�R�@c�@3>2>6>5>4>1
 a>d>b>c�@�S�@d�@4>3>1>5>6>2
 d>a>c>b�@�T�@
 b>a>d>c�@�U�@�@
 ������
 6
 4
 0 1 2 3
 1 2 0 3
 2 3 0 1
 0 3 1 2
 3 0 2 1
 1 0 3 2
 0 1 2 3 4 5
 5 4 3 2 1 0
 2 1 5 4 3 0
 3 2 0 4 5 1
 2
 3
 ���o��
 blue 0 �̍���, 0�l�̓L�[�v��
 blue 0 �� 0 �Ԗڌ�� 0 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 0 �̍���, 1�l�̓L�[�v��
 blue 0 �� 1 �Ԗڌ�� 1 (red����� 5 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 1 �̍���, 0�l�̓L�[�v��
 blue 1 �� 0 �Ԗڌ�� 1 (red����� 4 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 1 �̍���, 1�l�̓L�[�v��
 blue 1 �� 1 �Ԗڌ�� 2 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 2 �̍���, 0�l�̓L�[�v��
 blue 2 �� 0 �Ԗڌ�� 2 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 2 �̍���, 1�l�̓L�[�v��
 blue 2 �� 1 �Ԗڌ�� 3 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 3 �̍���, 0�l�̓L�[�v��
 blue 3 �� 0 �Ԗڌ�� 0 (red����� 3 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 3 �̍���, 1�l�̓L�[�v��
 blue 3 �� 1 �Ԗڌ�� 3 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 4 �̍���, 0�l�̓L�[�v��
 blue 4 �� 0 �Ԗڌ�� 3 (red����� 3 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 4 �̍���, 1�l�̓L�[�v��
 blue 4 �� 1 �Ԗڌ�� 0 (red����� 4 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 5 �̍���, 0�l�̓L�[�v��
 blue 5 �� 0 �Ԗڌ�� 1 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 5 �̍���, 1�l�̓L�[�v��
 blue 5 �� 1 �Ԗڌ�� 0 �ɍ�����f��
 blue 5 �̍���, 1�l�̓L�[�v��
 blue 5 �� 2 �Ԗڌ�� 3 �ɍ�����f��
 blue 5 �̍���, 1�l�̓L�[�v��
 blue 5 �� 3 �Ԗڌ�� 2 (red����� 2 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 --- blue ---
 blue 0 : 0,1,
 blue 1 : 1,2,
 blue 2 : 2,3,
 blue 3 : 0,3,
 blue 4 : 3,0,
 blue 5 : 1,2,

 --- red ---
 red 0 : 0,3,4,
 red 1 : 5,1,0,
 red 2 : 2,1,5,
 red 3 : 3,2,4,

 �y�e�X�g3����: 4:6 �ŃL�[�v3:2�z
 ���Q�l
 ��w�@�@�@�@�@�@�@�@�@�@���Z
 1>2>3>4>5>6�@a  1�@a>b>c>d�@
 6>5>4>3>2>1�@b  2�@b>c>a>d �@
 3>2>6>5>4>1�@c  3�@c>d>a>b�@
 4>3>1>5>6>2�@d  4�@a>d>b>c
 �@�@�@�@�@�@�@�@  �T�@d>a>c>b
 �@�@�@�@�@�@�@�@  �U�@b>a>d>c
 ������
 4
 6
 0 1 2 3 4 5
 5 4 3 2 1 0
 2 1 5 4 3 0
 3 2 0 4 5 1
 0 1 2 3
 1 2 0 3
 2 3 0 1
 0 3 1 2
 3 0 2 1
 1 0 3 2
 3
 2
 ���o��
 blue 0 �̍���, 0�l�̓L�[�v��
 blue 0 �� 0 �Ԗڌ�� 0 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 0 �̍���, 1�l�̓L�[�v��
 blue 0 �� 1 �Ԗڌ�� 1 (red����� 2 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 0 �̍���, 2�l�̓L�[�v��
 blue 0 �� 2 �Ԗڌ�� 2 (red����� 2 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 1 �̍���, 0�l�̓L�[�v��
 blue 1 �� 0 �Ԗڌ�� 5 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 1 �̍���, 1�l�̓L�[�v��
 blue 1 �� 1 �Ԗڌ�� 4 (red����� 3 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 1 �̍���, 2�l�̓L�[�v��
 blue 1 �� 2 �Ԗڌ�� 3 (red����� 2 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 2 �̍���, 0�l�̓L�[�v��
 blue 2 �� 0 �Ԗڌ�� 2 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 2 �̍���, 1�l�̓L�[�v��
 blue 2 �� 1 �Ԗڌ�� 1 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 2 �̍���, 2�l�̓L�[�v��
 blue 2 �� 2 �Ԗڌ�� 5 (red����� 3 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 3 �̍���, 0�l�̓L�[�v��
 blue 3 �� 0 �Ԗڌ�� 3 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 3 �̍���, 1�l�̓L�[�v��
 blue�� 0 ���� 2 �Ԗڌ��ł���red 2 ���񂩂�L�[�v����
 blue 3 �� 1 �Ԗڌ�� 2 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���ǂ�)
 blue 0 �̍���, 2�l�̓L�[�v��
 blue�� 1 ���� 2 �Ԗڌ��ł���red 3 ���񂩂�L�[�v����
 blue 0 �� 3 �Ԗڌ�� 3 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���ǂ�)
 blue 1 �̍���, 2�l�̓L�[�v��
 blue 1 �� 3 �Ԗڌ�� 2 �ɍ�����f��
 blue 1 �̍���, 2�l�̓L�[�v��
 blue�� 0 ���� 1 �Ԗڌ��ł���red 1 ���񂩂�L�[�v����
 blue 1 �� 4 �Ԗڌ�� 1 (red����� 0 �Ԗڌ��) �ɍ��� (���R ���ǂ�)
 blue 0 �̍���, 2�l�̓L�[�v��
 blue 0 �� 4 �Ԗڌ�� 4 (red����� 1 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 blue 3 �̍���, 2�l�̓L�[�v��
 blue 3 �� 2 �Ԗڌ�� 0 (red����� 3 �Ԗڌ��) �ɍ��� (���R ���Ȃ�)
 --- blue ---
 blue 0 : 0,3,4,
 blue 1 : 5,4,1,
 blue 2 : 2,1,5,
 blue 3 : 3,2,0,

 --- red ---
 red 0 : 0,3,
 red 1 : 1,2,
 red 2 : 2,3,
 red 3 : 0,3,
 red 4 : 0,1,
 red 5 : 1,2,

*/
public class GaleShapley {

    class Request{
	int[] partner;
	boolean[] selection;
	boolean[] bad;
	int keepCount;

	public Request(int n) {
	    partner = new int[n];
	    selection = new boolean[n];
	    bad = new boolean[n];
	    keepCount = 0;
	}

	int getNumber(int i){
	    return partner[i];
	}

	int getIndex(int number){
	    for(int i=0;i<partner.length;i++){
		if(partner[i]==number){
		    return i;
		}
	    }
	    return -1;
	}

	/**
	 * �L�[�v���Ă��钆�ōň��҂̌��ԍ����擾����
	 * @return
	 */
	int getKeepWorstIndex(){
	    for(int i=partner.length-1;i>=0;i--){
		if(selection[i]){
		    return i;
		}
	    }
	    return -1;
	}

	boolean isBad(int i){
	    return bad[i]? true : false;
	}

	/**
	 * index�Ԗڂ��L�[�v���Ă���
	 * @param index�Ԗ�
	 * @return �L�[�v��
	 */
	boolean isKeep(int index) {
	    return selection[index]? true : false;
	}

	/**
	 * �L�[�v�l��
	 * @return
	 */
	int getKeepCount(){
	    return keepCount;
	}

	void printSelected(){
	    for(int i=0;i<partner.length;i++){
		if(selection[i]){
		    System.out.print(partner[i]+",");
		}
	    }
	    System.out.println();
	}

	void setPartner(int i, int p){
	    partner[i] = p;
	}

	void setSelect(int i){
	    if(!selection[i]){
		keepCount++;
	    }
	    selection[i] = true;
	}

	void setBad(int i){
	    bad[i] = true;
	}

	void removeSelect(int i){
	    if(selection[i]){
		keepCount--;
	    }
	    setBad(i);
	    selection[i] = false;
	}

    }

    int blueN;
    int redN;
    Request[] blue_request;
    Request[] red_request;
    int processCount = 0;
    int blue_max_keep;
    int red_max_keep;

    public static void main(String[] args) {
	new GaleShapley().run();

    }

    private void run() {
	input();
	calculate();
	output();
    }

    private void output() {
	System.out.println("--- blue ---");
	for(int i=0;i<blueN;i++){
	    System.out.print("blue "+i+" : ");
	    blue_request[i].printSelected();
	}
	System.out.println();
	System.out.println("--- red ---");
	for(int i=0;i<redN;i++){
	    System.out.print("red "+i+" : ");
	    red_request[i].printSelected();
	}
    }

    private void calculate() {
	while(!isAllSelected()){
	    //			processCount++;
	    //			if(processCount>10){
	    //				return;
	    //			}
	    SelectProcess:
	    // ������ i
	    for(int i=0;i<blueN;i++){
		// ������ i �̃L�[�v�l���� �ő�l�ɂȂ��Ă��Ȃ�
		if(blue_request[i].getKeepCount()!=blue_max_keep){
		    // �����̑I���A�������s
		    System.out.println("blue "+i+" �̍���, "
				       +blue_request[i].getKeepCount()+"�l�̓L�[�v��");
		    // ��⏇��
		    for(int j=0;j<redN;j++){
			// ��� j �Ԗڂ� red t ����ɒ���
			int t = blue_request[i].getNumber(j);
			// blue ������ i �� j �Ԗڌ��ɑ΂�����ɒf���ĂȂ� ���@j�Ԗڂ����ɃL�[�v���ĂȂ�
			if(!blue_request[i].isBad(j)&&!blue_request[i].isKeep(j)){
			    // red t����� �L�[�v�l���� �ő�l�ɂȂ��Ă��Ȃ�
			    if(red_request[t].getKeepCount()!=red_max_keep){
				// blue i ���� �� ��� j �Ԗڂ̍����ɐ���
				blue_request[i].setSelect(j);
				// red t ����ɂƂ��Ă� ������ blue i ����̗D��x
				int y = red_request[t].getIndex(i);
				// red t ����� y�Ԗڂ̌�₪����
				red_request[t].setSelect(y);
				System.out.println("\tblue "+i+" �� "+j+" �Ԗڌ�� "
						   +t+" (red����� "+y+" �Ԗڌ��) �ɍ��� (���R ���Ȃ�)");
				break SelectProcess;
			    }
			    // red t����̍ň��҃L�[�v�̌�⏇�ʂ��@������blue i ����̌�⏇�ʂ��Ⴂ(�������傫��)
			    else if(red_request[t].getKeepWorstIndex()>red_request[t].getIndex(i)){
				// red t ����̍ň��L�[�v��⏇�� before
				int before = red_request[t].getKeepWorstIndex();
				// red t ����� ��� before �Ԗڂ̍ň��҂� ���f��
				red_request[t].removeSelect(before);
				// ���u���[����f��K�v������
				{
				    int before_blue = red_request[t].getNumber(before);
				    int blue_priority = blue_request[before_blue].getIndex(t);
				    blue_request[before_blue].removeSelect(blue_priority);
				    System.out.println("\tblue�� "+before_blue+" ���� "
						       +blue_priority+" �Ԗڌ��ł���red "+t+" ���񂩂�L�[�v����");
				}
				blue_request[i].setSelect(j);
				int y = red_request[t].getIndex(i);
				red_request[t].setSelect(y);
				System.out.println("\tblue "+i+" �� "+j+" �Ԗڌ�� "
						   +t+" (red����� "+y+" �Ԗڌ��) �ɍ��� (���R ���ǂ�)");
				break SelectProcess;
			    }
			    else{
				blue_request[i].setBad(j);
				System.out.println("\tblue "+i+" �� "+j+" �Ԗڌ�� "+t+" �ɍ�����f��");
				break SelectProcess;
			    }
			}
		    }
		}
	    }
	}
    }

    /**
     * ������(�u���[)�̑S���ɂ��āA�󂫂��[�����m�F
     * @return �󂫃[���̐^�U�l
     */
    private boolean isAllSelected() {
	for(int i=0;i<blueN;i++){
	    if(blue_request[i].getKeepCount()!=blue_max_keep){
		return false;
	    }
	}
	return true;
    }

    private void input() {
	@SuppressWarnings("resource")
	    Scanner stdIn = new Scanner(System.in);
	blueN = stdIn.nextInt();
	redN = stdIn.nextInt();
	blue_request = new Request[blueN];
	for(int i=0;i<blueN;i++){
	    blue_request[i] = new Request(redN);
	    for(int j=0;j<redN;j++){
		blue_request[i].setPartner(j, stdIn.nextInt());
	    }
	}
	red_request = new Request[redN];
	for(int i=0;i<redN;i++){
	    red_request[i] = new Request(blueN);
	    for(int j=0;j<blueN;j++){
		red_request[i].setPartner(j, stdIn.nextInt());
	    }
	}
	blue_max_keep = stdIn.nextInt();
	red_max_keep = stdIn.nextInt();
    }
}
