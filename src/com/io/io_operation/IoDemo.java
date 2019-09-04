package com.io.io_operation;


import java.io.*;

public class IoDemo {
    //    private static String sourcepath = "E:/binlog.000018";
    private String sourcepath = this.getClass().getResource("").getPath();
    private static String targetpath = "E:/copybinlog.000018";


    /**
     * ����Java�ļ�����������
     */
    public void testFile() {
        File file = new File(sourcepath);
        File[] strings = file.listFiles();
        file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    /**
     * ��������������ȡ�ı����������
     * �ֽ���
     *
     * @throws Exception
     */
    public void testInputStream() throws Exception {
        InputStream inputStream = new FileInputStream(sourcepath);
        File file = new File(targetpath);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);
        int data = 0;
        byte[] bytes = new byte[1024];
        while ((data = inputStream.read(bytes)) != -1) {
//            outputStream.write(bytes,0,data);
        }
        inputStream.close();
    }

    public void testBufferedInputStream() throws Exception {
        InputStream inputStream = new FileInputStream(sourcepath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int data = 0;
        while ((data = bufferedInputStream.read()) != -1) {

        }
        bufferedInputStream.close();
        inputStream.close();
    }

    /**
     * �������룬�ַ�����ȡ�ı��������
     *
     * @throws Exception
     */
    public void testRead() throws Exception {
        char[] chars = new char[10];
        FileReader reader = new FileReader(sourcepath);
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
        FileReader reader = new FileReader(sourcepath);
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
        OutputStream outputStream = new FileOutputStream(sourcepath);
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
        FileWriter writer = new FileWriter(sourcepath);
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
        Reader reader = new InputStreamReader(new FileInputStream(sourcepath));
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
        Writer writer = new OutputStreamWriter(new FileOutputStream(sourcepath));
        String text = "�����ı������";
        writer.write(text);
        writer.write("���");
        writer.close();
    }

    /**
     * �����ڴ�Ļ���������InputStreamʹ��
     */
    public void testByteArrayInputStream() {

    }

    /**
     * ��Stringת����InputStream
     */
    public void testStringBufferInputStream() {

    }

    /**
     * ��������д�����PipedOutputStream�����ݡ�ʵ��"�ܵ���"����
     */
    public void testPipedInputStream() {

    }

    /**
     * ����������InputStream����ת���ɵ�һInputStream
     */
    public void testSequenceInputStream() {

    }

    /**
     * �����࣬��Ϊ"װ����"�Ľӿڡ�����"װ����"Ϊ������
     * InputStream���ṩ���ù���
     */
    public void testFilterInputStream() {

    }


    /**
     * ���ڴ��д�������������������"��"�����ݶ�Ҫ�����ڴλ�����
     */
    public void testByteArrayOutputStream() {

    }

    /**
     * �κ�д�����е���Ϣ�����Զ���Ϊ���PipedInputStream�������ʵ��"�ܵ���"����
     */
    public void testPipedOutputStream() {

    }

    /**
     * �����࣬��Ϊ"װ����"�Ľӿڣ����У�"װ����"Ϊ����OutputStream�ṩ���ù���
     */
    public void testFilterOutputStream() {

    }


    public static void main(String[] args) throws Exception {
        IoDemo ioDemo = new IoDemo();
        /*long start = System.currentTimeMillis();
        ioDemo.testInputStream();
        long end = System.currentTimeMillis();
        System.out.println("����ʱ��:"+(end-start));*/
        ioDemo.testFile();


        /*long start1 = System.currentTimeMillis();
        ioDemo.testBufferedInputStream();
        long end1 = System.currentTimeMillis();
        System.out.println("Buffered����ʱ��:"+(end1-start1));*/
    }

}
