package d0707;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MemberProc extends JFrame implements ActionListener {
	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail; //id, �̸�, �ּ�, �̸���
	JTextField tfTel1, tfTel2, tfTel3; //��ȭ��ȣ
	JComboBox cbJob; //����
	JPasswordField pfPwd; //��й�ȣ
	JTextField tfYear, tfMonth, tfDate; //�������
	JRadioButton rbMan, rbWoman; //��,��
	JTextArea taIntro; //�Ұ�
	JButton btnInsert, btnCancle, btnUpdate, btnDelete; //���, ���, ����, Ż��
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Member_List mList;
	
	public MemberProc() { //�ű԰����� ���
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
	
	public MemberProc(String id, Member_List mList) { //����, Ż���� ���
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;
		
		System.out.println("id=" + id); //���� ���õ� id�� �ֿܼ� �����ش�.
		
		//���õ� id�� �ش��ϴ� ������ �����ͺ��̽����� �����ͼ� �� �ʵ忡 ����Ѵ�.
		MemberDAO dao  = new MemberDAO();
		MemberDTO vMem = dao.getMemberDTO(id);
		//������ �����͸� ȭ���� �ʵ忡 ����Ѵ�.
		viewData(vMem);
	}
	
	//id�� �ش��ϴ� ������ ȭ�鿡 �����ش�.
	private void viewData(MemberDTO vMem) {
		//�Ѱܹ��� ������ ȭ�鿡 �����ִ� �۾��� �ϱ� ���ؼ� ������ �����Ѵ�.
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
		
		//������ �������� ������ ȭ�鿡 �°� �����ֱ� ���� �۾��� �Ѵ�.
		//member ���̺��� ������ ���� id�̹Ƿ� id�� �����ϸ� �ʵȴ�.
		tfId.setText(id);
		tfId.setEditable(false);
		pfPwd.setText("");//��й�ȣ�� ȭ�鿡 ������ �ʱ� ���ؼ�
		tfName.setText(name);
		//��ȭ��ȣ�� 010-1234-5678�� �ڷᰡ ��ϵǾ� �ֱ� ������ '-'�� �������� �и��ؼ� ȭ�鿡 �����ش�.
		String[] tels = tel.split("-");
		tfTel1.setText(tels[0]);
		tfTel2.setText(tels[1]);
		tfTel3.setText(tels[2]);
		tfAddr.setText(addr);
		
		//��������� yyyymmdd�������� �ڷᰡ �ֱ⶧���� yyyy mm dd�� �и��ؼ� ȭ�鿡 �����ش�.
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
		this.setTitle("ȸ��������");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill  = GridBagConstraints.BOTH; // ���� �ٽ�
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// ���̵� 0
		JLabel bId = new JLabel("���̵�");
		tfId = new JTextField(20);
		gbAdd(bId,0,0,1,1);
		gbAdd(tfId,1,0,3,1);
		
		//��й�ȣ 1
		JLabel bPwd = new JLabel("��й�ȣ");
		pfPwd = new JPasswordField(20);
		gbAdd(bPwd,0,1,1,1);
		gbAdd(pfPwd,1,1,3,1);
		
		//�̸� 2
		JLabel bname = new JLabel("�̸�");
		tfName = new JTextField(20);
		gbAdd(bname,0,2,1,1);
		gbAdd(tfName,1,2,3,1);
		
		//��ȭ 3
		JLabel bTel = new JLabel("��ȭ��ȣ");
		// �׸���鿡 ��ȭ��ȣ �ʵ���� �����ؼ� ���̱� ���ؼ� ���� �ǳڿ� ���� �ø���.
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
		
		//�ּ� 4
		JLabel bAddr = new JLabel("�ּ�");
		tfAddr = new JTextField(20);
		gbAdd(bAddr,0,4,1,1);
		gbAdd(tfAddr,1,4,3,1);
		
		//������� 5
		JLabel bBirth = new JLabel("�������");
		// �׸���鿡 ��ȭ��ȣ �ʵ���� �����ؼ� ���̱� ���ؼ� ���� �ǳڿ� ���� �ø���.
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfYear = new JTextField(6);
		tfMonth = new JTextField(6);
		tfDate = new JTextField(6);
		pBirth.add(tfYear);
		pBirth.add(new JLabel(" �� "));
		pBirth.add(tfMonth);
		pBirth.add(new JLabel(" �� "));
		pBirth.add(tfDate);
		pBirth.add(new JLabel(" �� "));
		
		gbAdd(bBirth,0,5,1,1);
		gbAdd(pBirth,1,5,3,1);
		
		// ���� 6
		JLabel bJob = new JLabel("����");
		String[] arrJob = {"---", "�л�", "������", "�����"};
		cbJob = new JComboBox(arrJob);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(cbJob);
		gbAdd(bJob,0,6,1,1);
		gbAdd(pJob,1,6,3,1);
		
		// ���� 7
		JLabel vGender = new JLabel("����");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("��",true);
		rbWoman = new JRadioButton("��",true);
		// �ϳ��� �����ֱ� ���ؼ�(�ϳ��� �����ϰ� �ϱ� ���ؼ�) group���� �����־����.
		// ������ư�� �׷����� ������ �Ѱ����ۿ� ������ �� �� ����.
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
		
		pGender.add(rbMan);
		pGender.add(rbWoman);
		
		gbAdd(vGender,0,7,1,1);
		gbAdd(pGender,1,7,3,1);
		
		// �̸��� ��8
		JLabel bEmail = new JLabel("�̸����ּ�");
		tfEmail = new JTextField(20);
		gbAdd(bEmail,0,8,1,1);
		gbAdd(tfEmail,1,8,3,1);
		
		// �Ұ�  9
		JLabel bIntro = new JLabel("�Ұ�");
		taIntro = new JTextArea(6,20); // ��� ��
		// TextArea�� ������ ������ �� ���� �Է��� �� �����Ƿ� ��ũ���� �߻��ϰ� ��ũ�����ο� ���Խ�Ų��.
		
		JScrollPane pane = new JScrollPane(taIntro);
		gbAdd(bIntro,0,9,1,1);
		gbAdd(pane,1,9,3,1);
		
		//��ư
		JPanel pButton = new JPanel();
		btnInsert = new JButton("����");
		btnUpdate = new JButton("����");
		btnDelete = new JButton("Ż��");
		btnCancle = new JButton("���");
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancle);
		gbAdd(pButton,0,10,4,1);
		
		//�� ��ư���� �����ʸ� �ٿ��ش�.
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancle.addActionListener(this);
		
		setLocation(400,200);
		setSize(400,500);
		setVisible(true);
		// ����Ʈ���� ������ ������ �������� �� ���� ������ ������ â�� �ߴµ�, �װ��� ������
		// ����Ʈâ�� ����־���ϹǷ�, EXIT_ON_CLOSE�� ���� �ƴ϶�
		// DISPOSE_ON_CLOSE�� ����Ѵ�. (���� â�� �ݴ´�)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//GridBagLayout�� ������Ʋ�� ���̴� �޼ҵ�
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
		if(e.getSource()==btnInsert){ //�űԵ�� ��ư�� ������ ���
			insertMember(); // ȭ�鿡 �Էµ� ������ �����ͺ��̽��� ������ִ� �޼��带 ȣ���Ѵ�.
		}
	} // End actionPerformed(ActionEvent e)
	
	//ȸ�� ��� �޼���
	private void insertMember(){
		// ȭ�鿡�� �Է��� �������� ��´�.
		MemberDTO dto = getViewData();
		// DB�� �����ϱ� ���ؼ� MemberDAO�� �����Ѵ�.
		MemberDAO dao = new MemberDAO();
		// ������ ����(dto)
		boolean ok = dao.insertMember(dto);
		if(ok ==true){
			JOptionPane.showMessageDialog(this, "ȸ�������� ���ϵ帳�ϴ�");
		}else{
			JOptionPane.showMessageDialog(this, "����ó���� ���� �ʾҽ��ϴ�.\n�ٽ� �� �� �õ��Ͻʽÿ�.");
		}
	}
	
	//ȭ�鿡�� �Է��� �������� ��´�. (����, ����, Ż�𿡼� �������� ���)
	public MemberDTO getViewData(){
		MemberDTO dto = new MemberDTO();
		String id		= tfId.getText();
		String pwd		= pfPwd.getText();
		String name		= tfName.getText();
		String tel1		= tfTel1.getText();
		String tel2		= tfTel2.getText();
		String tel3		= tfTel3.getText();
		// ���ļ� �ϳ��� �����.
		String tel 		= tel1+"-"+tel2+"-"+tel3;
		String addr 	= tfAddr.getText(); 
		String year		= tfYear.getText();
		String month	= tfMonth.getText();
		String date 	= tfDate.getText();
		// ��������� ���ļ� �ϳ��� �����
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
































