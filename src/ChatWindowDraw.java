import java.awt.event.*;
import java.util.List;

import java.awt.*;
import java.util.ArrayList;

public class ChatWindowDraw extends Frame implements Runnable  {



      private Graphics graphics1 = null;

      public ChatWindowDraw(){}
      public ChatWindowDraw(Graphics g) {
        this.graphics1 = g;
    }

@Override
    public void run() {
       System.out.println("绘制线程已启动");

//       Frame f  = new Frame();
        while (true) {
//            ChatWindowContext chatWindowContext = ChatWindowContext.getInstance1();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (graphics1 != null) {
//                ChatFrame chatFrame = (ChatFrame)chatWindowContext.getInstance1().getContext("chat");
//                chatFrame.paint(getGraphics1());
            }

            List<ChatWindowClient> chatWindowClientList = new ArrayList<ChatWindowClient>();
            for (int i = 0; i < chatWindowClientList.size(); i++) {
//                ChatWindowClient ClienNumber = chatWindowClientList.get(i);
                Color defaultColor = new Color(250, 150, 100);
//                f.setBounds(100,200,900,900);
                graphics1.fillRect(200, 100, 650, 650);
            //输入框
                graphics1.setColor(defaultColor);
                Label message = new Label();
                TextField text = new TextField(50);

                // 按钮事件
                Panel centerPanel = new Panel();
                Button enter = new Button("发送");
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        message.setText("用户"+chatWindowClientList.size());
                    }
                });
//                f.add(message,BorderLayout.SOUTH);
                centerPanel.add(text);
                centerPanel.add(enter);
//                f.pack();
//                f.setVisible(true);

                System.out.println("聊天室人数" + i);
            }
//            graphics1.drawString("聊天室人数" + chatWindowClientList.size(), 200, 100);
            //关闭窗口
//                f.addWindowListener(new WindowAdapter() {
//
//                    public void windowClosing(WindowEvent windowEvent){
//                       System.exit(0);
//                    }
//                });
        }

    }

    public Graphics getGraphics1 (){
          return graphics1;
    }
    public Graphics setGraphics1(Graphics graphics1){
         this.graphics1 =graphics1;
         return graphics1;
    }

}
