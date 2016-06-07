package vo;

/**
 * Created by dimitrov on 08.06.16.
 */
public class BaseVO extends ValueObject
{
    public String base;
    public String description;

    public BaseVO()
    {

    }

    public String getBase()
    {
        return base;
    }

    public void setBase(String base)
    {
        this.base = base;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
