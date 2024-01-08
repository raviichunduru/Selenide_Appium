package enums;

public enum Product
{
    PG3 ("PG 3"),
    CONVERSE_ALL_STAR ("Converse All Star"),
    JORDAN_6_Rings ("Jordan 6 Rings");

    String product;

    Product(String product)
    {
        this.product = product;
    }

    public String getProduct()
    {
        return product;
    }
}
