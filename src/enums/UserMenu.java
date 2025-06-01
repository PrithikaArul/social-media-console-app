package enums;


public enum UserMenu {

    CREATE_POST(1),
    VIEW_YOUR_POSTS(2),
    ADD_A_FRIEND(3),
    VIEW_FEED(4),
    LOGOUT(5);

    private final int value;

    UserMenu(int value){
        this.value=value;
    }

    public int getValue()
    {
        return this.value;
    }

    public static UserMenu fromInt(int choice)
    {
        for(UserMenu option: UserMenu.values())
        {
            if(option.getValue()==choice)
            {
                return option;
            }
        }
        return null;
    }
}
