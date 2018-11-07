package targetVO;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/31.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Member implements Comparable<Member> {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
