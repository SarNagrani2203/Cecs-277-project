package Code;

public class Magical extends Entity{
    public Magical(String n, int maxHp) {
        super(n, maxHp);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String attack(Entity e)
    {
        return (super.getName()+" attacks "+e.getName());
    }
}