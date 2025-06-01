package enums;

public enum MainMenu {

    SIGN_UP(1),
    LOGIN(2),
    LIST_USERS(3);

    private final int value;

    MainMenu(int value)
    {
        this.value=value;
    }

    public int getValue()
    {
        return this.value;
    }

    public static MainMenu fromInt(int choice)
    {
        for(MainMenu option:MainMenu.values())
        {
            if(option.getValue()==choice)
            {
                return option;
            }
        }

        return null;
    }

}
