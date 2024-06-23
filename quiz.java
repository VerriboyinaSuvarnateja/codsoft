import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class quiz extends JFrame implements ActionListener{
        JLabel l1,counterlabel,start_time;
        Timer timer;
        JRadioButton radiobuttons[]=new JRadioButton[5]; 
        JButton next,result;
        ButtonGroup bg;
        int score=0,current_q=0,x=1,y=1,now=0;
        int que[]=new int[10];
        int second,minute;
        String ddsecond,ddminute;
        DecimalFormat dFormat;
        public quiz(String s){
           super(s);
           l1=new JLabel();
           add(l1);
           bg=new ButtonGroup();
           for(int i=0;i<5;i++){
                 radiobuttons[i]=new JRadioButton();
                 add(radiobuttons[i]);
                 bg.add(radiobuttons[i]);
           }
           next=new JButton("NEXT");
           result=new JButton("GET RESULT");
           result.setVisible(false);
           result.addActionListener(this);
           next.addActionListener(this);
           add(next);
           add(result);    
           setData();
           l1.setBounds(50,50,400,20);
           radiobuttons[0].setBounds(50,70,100,20);
           radiobuttons[1].setBounds(50,90,100,20);
           radiobuttons[2].setBounds(50,110,100,20);
           radiobuttons[3].setBounds(50,130,100,20);
           next.setBounds(100,240,100,20);
           result.setBounds(200,150,100,30);
           result.setBackground(Color.RED);
           dFormat=new DecimalFormat("00");
           counterlabel=new JLabel();
           counterlabel.setBounds(500,20,100,40);
           counterlabel.setText("01:00");

           add(counterlabel);
           start_time=new JLabel("start_time");
           start_time.setBounds(500,5,100,40);
           add(start_time);
           
           setLayout(null);
           setVisible(true);
           setSize(600,500);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void countdown_timer(){
             second=0;
             minute=1;
             
             timer=new Timer(1000,new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                            second--;

                            ddsecond=dFormat.format(second);
                            ddminute=dFormat.format(minute);
                            counterlabel.setText(ddminute+":"+ddsecond);
                            if(second==-1){
                                  second=59;
                                  minute--;
                     
                                  ddsecond=dFormat.format(second);
                                  ddminute=dFormat.format(minute);
                                  counterlabel.setText(ddminute+":"+ddsecond);
                            }
                            if(minute==0&&second==0){
                                  timer.stop();
                            }
                   }
             });
       }
         
        void setData(){
             radiobuttons[4].setSelected(true);
             if(current_q==0){
                    l1.setText("1)Which official langusge is used for android development?");
                    radiobuttons[0].setText("Java");
                    radiobuttons[1].setText("python");
                    radiobuttons[2].setText("kotlin");
                    radiobuttons[3].setText("c++");
                    countdown_timer();
                    timer.start();

             }
             if(current_q==1){
                    l1.setText("2)Which symbol is used for multiline comments in java?");
                    radiobuttons[0].setText("/!");
                    radiobuttons[1].setText("/.");
                    radiobuttons[2].setText("//");
                    radiobuttons[3].setText("/**/");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==2){
                    l1.setText("3)What is the return type of the hashCode() method in the Object class??");
                    radiobuttons[0].setText("Object");
                    radiobuttons[1].setText("void");
                    radiobuttons[2].setText("int");
                    radiobuttons[3].setText("long");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==3){
                    l1.setText("4)Who invented java?");
                    radiobuttons[0].setText("James Gosling");
                    radiobuttons[1].setText("Michael");
                    radiobuttons[2].setText("sanata");
                    radiobuttons[3].setText("jack");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==4){
                    l1.setText("5)_____ is used to find and fix bugs in the Java programs.?");
                    radiobuttons[0].setText("JVM");
                    radiobuttons[1].setText("JDK");
                    radiobuttons[2].setText("JFI");
                    radiobuttons[3].setText("JDB");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==5){
                    l1.setText("6)An interface with no fields or methods is known as a ______.?");
                    radiobuttons[0].setText("Runnable");
                    radiobuttons[1].setText("Marker");
                    radiobuttons[2].setText("Abstract");
                    radiobuttons[3].setText("charsequence");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==6){
                    l1.setText("7)Which of the following is an immediate subclass of the Panel class?");                   
                    radiobuttons[0].setText("Applet class");
                    radiobuttons[1].setText("Window class");
                    radiobuttons[2].setText("Frame class");
                    radiobuttons[3].setText("Dialog class");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==7){
                    l1.setText("8)What do you mean by chained exceptions in Java?");
                    radiobuttons[0].setText("Exceptions occurred by the VirtualMachineError");
                    radiobuttons[1].setText("An exception caused by other exceptions");
                    radiobuttons[2].setText("Exceptions occur in chains with discarding the debugging information");
                    radiobuttons[3].setText("IOException and VirtualMachineError class");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==8){
                    l1.setText("9) In which memory a String is stored, when we create a string using new operator?");
                    radiobuttons[0].setText("Stack");
                    radiobuttons[1].setText("String memory");
                    radiobuttons[2].setText("Heap memory");
                    radiobuttons[3].setText("Random storage space");
                    countdown_timer();
                    timer.start();


             }
             if(current_q==9){
                    l1.setText("10)Which of the following is a marker interface?");
                    radiobuttons[0].setText("Result interface");
                    radiobuttons[1].setText("remote interface");
                    radiobuttons[2].setText("readable interface");
                    radiobuttons[3].setText("runnable interface");
                    countdown_timer();
                    timer.start();


             }
             l1.setBounds(50,50,400,20);
             for(int i=0,j=0;i<=70;i+=20,j++){
                    radiobuttons[j].setBounds(50,70+i,100,20);
             }
      }
      boolean checking_ans(){
             if(current_q==0){
                    return(radiobuttons[2].isSelected());
             }
             if(current_q==1){
                    return(radiobuttons[3].isSelected());
             }
             if(current_q==2){
                    return(radiobuttons[2].isSelected());
             }
             if(current_q==3){
                    return(radiobuttons[0].isSelected());
             }
             if(current_q==4){
                    return(radiobuttons[3].isSelected());
             }
             if(current_q==5){
                    return(radiobuttons[1].isSelected());
             }
             if(current_q==6){
                    return(radiobuttons[0].isSelected());
             }
             if(current_q==7){
                    return(radiobuttons[2].isSelected());
             }
             if(current_q==8){
                    return(radiobuttons[2].isSelected());
             }
             if(current_q==9){
                    return(radiobuttons[1].isSelected());
             }
             return false;
      }
      public static void main(String[] args){
             new quiz("Start Quiz");
      }
      public void actionPerformed(ActionEvent e){
             if(e.getSource()==next){
                 if(checking_ans())
                      score+=1;
                 current_q++;
                 setData();
                 if(current_q==9){
                      next.setEnabled(false);
                      result.setVisible(true);
                      result.setText("GET RESULT");
                 }
             }
             if(e.getActionCommand().equals("GET RESULT")){
                      if(checking_ans())
                            score+=1;
                      current_q++;
                      JOptionPane.showMessageDialog(this,"your score is"+score++);
                      System.exit(0);
             }
      }
}   
             