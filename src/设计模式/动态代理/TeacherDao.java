package 设计模式.动态代理;



public class TeacherDao implements ITeacherDao {


    @Override
    public void tech() {
        System.out.println("老师授课");
    }
}
