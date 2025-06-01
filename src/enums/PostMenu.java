package enums;

public enum PostMenu {

    LIKE(1),
    COMMENT(2);

    private final int value;

    PostMenu(int value)
    {
        this.value=value;
    }

    public int getValue()
    {
        return this.value;
    }

    public static PostMenu fromInt(int choice)
    {
        for(PostMenu option:PostMenu.values())
        {
            if(option.getValue()==choice)
            {
                return option;
            }
        }
        return null;
    }
}
