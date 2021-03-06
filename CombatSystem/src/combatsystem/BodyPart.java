package combatsystem;

public class BodyPart {

    private int health;
    private boolean isWounded;
    private boolean isImpaired;
    private boolean isArmored;
    private BodyComponent component;

    public BodyPart(int h) {
        health = h;
    }

    public BodyPart(BodyComponent bc) {
        component = bc;
    }

    public BodyPart(int h, BodyComponent bc) {
        health = h;
        component = bc;
    }

    public int dealDamage(int i) {
        if (isImpaired) {
            return 0;
        }
        health = health - i;
        if (health < (health / 2)) {
            isWounded = true;
        }
        if (health < 0) {
            isImpaired = true;
            health = 0;
        }
        return health;
    }

    public int getHealth() {
        return health;
    }

    public boolean isIsImpaired() {
        return isImpaired;
    }

    public boolean isWounded() {
        return isWounded;
    }

    public boolean isIsArmored() {
        return isArmored;
    }

    public BodyComponent getComponent() {
        return component;
    }

    @Override
    public boolean equals(Object obj) {
        BodyPart temp;
        try {
            temp = (BodyPart) obj;
        } catch (Exception ignore) {
            return false;
        }
        if (temp == this) {
            return true;
        }
        return (temp.isIsArmored() == this.isIsArmored() && temp.isIsImpaired() == this.isIsImpaired() && temp.getComponent() == this.getComponent());
    }

    @Override
    public String toString() {
        return component + " " + health;
    }
}
