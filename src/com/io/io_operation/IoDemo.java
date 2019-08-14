package com.io.io_operation;


import java.io.*;

public class IoDemo {

    /**
     * ��������������ȡ�ı����������
     * �ֽ���
     *
     * @throws Exception
     */
    public void testInputStream() throws Exception {
        InputStream inputStream = new FileInputStream("D:/test.txt");
        int data = 0;
        byte[] bytes = new byte[10];
        StringBuffer sb = new StringBuffer();
        while ((data = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, "utf-8"));
        }
        System.out.println(sb.toString());
        inputStream.close();
    }

    public void testInputBufferStream() throws Exception {
        InputStream inputStream = new FileInputStream("D:/test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

    }

    /**
     * �������룬�ַ�����ȡ�ı��������
     *
     * @throws Exception
     */
    public void testRead() throws Exception {
        char[] chars = new char[10];
        FileReader reader = new FileReader("D:/test.txt");
        int data = 0;
        StringBuffer sb = new StringBuffer();
		/*while((data = reader.read(chars))!=-1){
			sb.append(chars,0,data);
		}*/
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
        reader.close();
    }


    /**
     * �ַ�����������
     *
     * @throws Exception
     */
    public void testBufferReader() throws Exception {
        FileReader reader = new FileReader("D:/test.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String data = null;
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(data);
        }
        bufferedReader.close();
        reader.close();
    }

    /**
     * �����������������������ı���
     *
     * @throws Exception
     */
    public void testOutputStream() throws Exception {
        OutputStream outputStream = new FileOutputStream("D:/test.txt");
        String text = "�����ı����";
        outputStream.write(text.getBytes());
        outputStream.close();
    }

    /**
     * ������������ֽڣ���������������ı���
     *
     * @throws IOException
     */
    public void testWriter() throws IOException {
        FileWriter writer = new FileWriter("D:/test.txt");
        String text = "�����ı�writer���";
        writer.write(text);
        writer.write("���");
        writer.close();
    }

    /**
     * ���Խ��ֽ�����װ���ַ������
     *
     * @throws FileNotFoundException
     */
    public void testInputStreamReader() throws Exception {
        Reader reader = new InputStreamReader(new FileInputStream("D:/test.txt"));
        int data = 0;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
        reader.close();
    }

    /**
     * ���ַ�����װ���ֽ������뵽�ı�
     *
     * @throws Exception
     */
    public void testOutputStreamWriter() throws Exception {
        Writer writer = new OutputStreamWriter(new FileOutputStream("D:/test.txt"));
        String text = "�����ı������";
        writer.write(text);
        writer.write("���");
        writer.close();
    }

    /**
     * �����ڴ�Ļ���������InputStreamʹ��
     */
    public void testByteArrayInputStream(){

    }

    /**
     * ��Stringת����InputStream
     */
    public void testStringBufferInputStream(){

    }

    /**
     * ��������д�����PipedOutputStream�����ݡ�ʵ��"�ܵ���"����
     */
    public void testPipedInputStream(){

    }

    /**
     * ����������InputStream����ת���ɵ�һInputStream
     */
    public void testSequenceInputStream(){

    }

    /**
     * �����࣬��Ϊ"װ����"�Ľӿڡ�����"װ����"Ϊ������
     * InputStream���ṩ���ù���
     */
    public void testFilterInputStream(){

    }


    /**
     * ���ڴ��д�������������������"��"�����ݶ�Ҫ�����ڴλ�����
     */
    public void testByteArrayOutputStream(){

    }

    /**
     * �κ�д�����е���Ϣ�����Զ���Ϊ���PipedInputStream�������ʵ��"�ܵ���"����
     */
    public void testPipedOutputStream(){

    }

    /**
     * �����࣬��Ϊ"װ����"�Ľӿڣ����У�"װ����"Ϊ����OutputStream�ṩ���ù���
     */
    public void testFilterOutputStream(){

    }


    public static void main(String[] args) throws Exception {
        IoDemo ioDemo = new IoDemo();
        ioDemo.testRead();
    }

}
