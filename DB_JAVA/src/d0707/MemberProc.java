package d0707;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MemberProc extends JFrame implements ActionListener {
	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail; //id, 이름, 주소, 이메일
	JTextField tfTel1, tfTel2, tfTel3; //전화번호
	JComboBox cbJob; //직업
	JPasswordField pfPwd; //비밀번호
	JTextField tfYear, tfMonth, tfDate; //생년월일
	JRadioButton rbMan, rbWoman; //남,여
	JTextArea taIntro; //소개
	JButton btnInsert, btnCancle, btnUpdate, btnDelete; //등록, 취소, 수정, 탈퇴
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Member_List mList;
	
	public MemberProc() { //신규가입일 경우
		createUI();
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
	}
	
	public MemberProc(Member_List mList) {
		createUI();
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
	}
	
	public MemberProc(String id, Member_List mList) { //수정, 탈퇴일 경우
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;
		
		System.out.println("id=" + id); //현재 선택된 id를 콘솔에 보여준다.
		
		//선택된 id에 해당하는 정보를 데이터베이스에서 가져와서 각 필드에 출력한다.
		MemberDAO dao  = new MemberDAO();
		MemberDTO vMem = dao.getMemberDTO(id);
		//가져온 데이터를 화면의 필드에 출력한다.
		viewData(vMem);
	}
	
	//id에 해당하는 정보를 화면에 보여준다.
	private void viewData(MemberDTO vMem) {
		//넘겨받은 정보를 화면에 보여주는 작업을 하기 위해서 변수에 저장한다.
		String id		= vMem.getId();
		String pwd		= vMem.getPwd();
		String name		= vMem.getName();
		String tel		= vMem.getTel();
		String addr		= vMem.getAddr();
		String birth	= vMem.getBirth();
		String job		= vMem.getJob();
		String gender	= vMem.getGender();
		String email	= vMem.getEmail();
		String intro	= vMem.getIntro();
		
		//저장한 변수들을 가지고 화면에 맞게 보여주기 위한 작업을 한다.
		//member 테이블에서 유일한 값은 id이므로 id를 수정하면 않된다.
		tfId.setText(id);
		tfId.setEditable(false);
		pfPwd.setText("");//비밀번호는 화면에 보이지 않기 위해서
		tfName.setText(name);
		//전화번호는 010-1234-5678로 자료가 등록되어 있기 떄문에 '-'를 기준으로 분리해서 화면에 보여준다.
		String[] tels = tel.split("-");
		tfTel1.setText(tels[0]);
		tfTel2.setText(tels[1]);
		tfTel3.setText(tels[2]);
		tfAddr.setText(addr);
		
		//생년월일은 yyyymmdd형식으로 자료가 있기때문에 yyyy mm dd를 분리해서 화면에 보여준다.
		tfYear.setText (birth.substring(0, 4));
		tfMonth.setText(birth.substring(4, 6));
		tfDate.setText (birth.substring(6, 8));
		
		cbJob.setSelectedItem(job);
		
		if(gender.equals("M")) {
			rbMan.setSelected(true);
		} else if(gender.equals("W")) {
			rbWoman.setSelected(true);
		}
		tfEmail.setText(email);
		taIntro.setText(intro);
	} // End ViewData(MemberDTO vMem)
	
	private void createUI() {
		this.setTitle("회원상세정보");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill  = GridBagConstraints.BOTH; // 여기 다시
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// 아이디 0
		JLabel bId = new JLabel("아이디");
		tfId = new JTextField(20);
		gbAdd(bId,0,0,1,1);
		gbAdd(tfId,1,0,3,1);
		
		//비밀번호 1
		JLabel bPwd = new JLabel("비밀번호");
		pfPwd = new JPasswordField(20);
		gbAdd(bPwd,0,1,1,1);
		gbAdd(pfPwd,1,1,3,1);
		
		//이름 2
		JLabel bname = new JLabel("이름");
		tfName = new JTextField(20);
		gbAdd(bname,0,2,1,1);
		gbAdd(tfName,1,2,3,1);
		
		//전화 3
		JLabel bTel = new JLabel("전화번호");
		// 그리드백에 전화번호 필드들을 분할해서 보이기 위해서 먼저 판넬에 만들어서 올린다.
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfTel1 = new JTextField(6);
		tfTel2 = new JTextField(6);
		tfTel3 = new JTextField(6);
		pTel.add(tfTel1);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel2);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel3);
		gbAdd(bTel,0,3,1,1);
		gbAdd(pTel,1,3,3,1);
		
		//주소 4
		JLabel bAddr = new JLabel("주소");
		tfAddr = new JTextField(20);
		gbAdd(bAddr,0,4,1,1);
		gbAdd(tfAddr,1,4,3,1);
		
		//생년월일 5
		JLabel bBirth = new JLabel("생년월일");
		// 그리드백에 전화번호 필드들을 분할해서 보이기 위해서 먼저 판넬에 만들어서 올린다.
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfYear = new JTextField(6);
		tfMonth = new JTextField(6);
		tfDate = new JTextField(6);
		pBirth.add(tfYear);
		pBirth.add(new JLabel(" 년 "));
		pBirth.add(tfMonth);
		pBirth.add(new JLabel(" 월 "));
		pBirth.add(tfDate);
		pBirth.add(new JLabel(" 일 "));
		
		gbAdd(bBirth,0,5,1,1);
		gbAdd(pBirth,1,5,3,1);
		
		// 직업 6
		JLabel bJob = new JLabel("직업");
		String[] arrJob = {"---", "학생", "직장인", "운동선수"};
		cbJob = new JComboBox(arrJob);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(cbJob);
		gbAdd(bJob,0,6,1,1);
		gbAdd(pJob,1,6,3,1);
		
		// 성별 7
		JLabel vGender = new JLabel("성별");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("남",true);
		rbWoman = new JRadioButton("여",true);
		// 하나로 묶어주기 위해서(하나만 선택하게 하기 위해서) group으로 묶어주어야함.
		// 라디오버튼은 그룹으로 묶으면 한가지밖에 선택을 할 수 없다.
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
		
		pGender.add(rbMan);
		pGender.add(rbWoman);
		
		gbAdd(vGender,0,7,1,1);
		gbAdd(pGender,1,7,3,1);
		
		// 이메일 ㅣ8
		JLabel bEmail = new JLabel("이메일주소");
		tfEmail = new JTextField(20);
		gbAdd(bEmail,0,8,1,1);
		gbAdd(tfEmail,1,8,3,1);
		
		// 소개  9
		JLabel bIntro = new JLabel("소개");
		taIntro = new JTextArea(6,20); // 행과 열
		// TextArea는 지정한 열보다 더 많이 입력할 수 있으므로 스크롤이 발생하게 스크롤페인에 포함시킨다.
		
		JScrollPane pane = new JScrollPane(taIntro);
		gbAdd(bIntro,0,9,1,1);
		gbAdd(pane,1,9,3,1);
		
		//버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("가입");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("탈퇴");
		btnCancle = new JButton("취소");
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancle);
		gbAdd(pButton,0,10,4,1);
		
		//각 버튼마다 리스너를 붙여준다.
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		
		setLocation(400,200);
		setSize(400,500);
		setVisible(true);
		// 리스트에서 선택한 정보를 눌렀으면 그 위에 선택한 정보의 창이 뜨는데, 그것을 끄더라도
		// 리스트창은 살아있어야하므로, EXIT_ON_CLOSE를 쓸게 아니라
		// DISPOSE_ON_CLOSE를 써야한다. (현재 창만 닫는다)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//GridBagLayout에 콤포넌틀르 붙이는 메소드
	private void gbAdd(JComponent c ,int x, int y, int w, int h){
		gbc.gridx= x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2,2,2,2);
		add(c,gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnInsert){ //신규등록 버튼을 눌렀을 경우
			insertMember(); // 화면에 입력된 정보로 데이터베이스에 등록해주는 메서드를 호출한다.
		}
	} // End actionPerformed(ActionEvent e)
	
	//회원 등록 메서드
	private void insertMember(){
		// 화면에서 입력한 정보들을 얻는다.
		MemberDTO dto = getViewData();
		// DB에 저장하기 위해서 MemberDAO를 생성한다.
		MemberDAO dao = new MemberDAO();
		// 취합한 정보(dto)
		boolean ok = dao.insertMember(dto);
		if(ok ==true){
			JOptionPane.showMessageDialog(this, "회원가입을 축하드립니다");
		}else{
			JOptionPane.showMessageDialog(this, "가입처리가 되지 않았습니다.\n다시 한 번 시도하십시오.");
		}
	}
	
	//화면에서 입력한 정보들을 얻는다. (가입, 수정, 탈퇴에서 공통으로 사용)
	public MemberDTO getViewData(){
		MemberDTO dto = new MemberDTO();
		String id		= tfId.getText();
		String pwd		= pfPwd.getText();
		String name		= tfName.getText();
		String tel1		= tfTel1.getText();
		String tel2		= tfTel2.getText();
		String tel3		= tfTel3.getText();
		// 합쳐서 하나로 만든다.
		String tel 		= tel1+"-"+tel2+"-"+tel3;
		String addr 	= tfAddr.getText(); 
		String year		= tfYear.getText();
		String month	= tfMonth.getText();
		String date 	= tfDate.getText();
		// 생년월일을 합쳐서 하나로 만든다
		String birth 	= year + month + date;
		String gender	= "";
		if(rbMan.isSelected()){
			gender = "M";
		} else{
			gender = "W";
		}
		String job		= (String)cbJob.getSelectedItem();
		String email	= tfEmail.getText();
		String intro	= taIntro.getText();
		
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddr(addr);
		dto.setBirth(birth);

		dto.setJob(job);
		dto.setGender(gender);
		dto.setEmail(email);
		dto.setIntro(intro);
		
		return dto;
	}
	
	public static void main(String[] args){
		new MemberProc();
	}
} // End Main Frame
































