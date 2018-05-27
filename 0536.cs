public class Program
{
    public static void Main(string[] args)
    {
        var name = System.Console.ReadLine();

        string id;
        if (name.EndsWith("ai"))
        {
            id = name.Substring(0, name.Length - 2) + "AI";
        }
        else
        {
            id = name + "-AI";
        }

        System.Console.WriteLine(id);

    }
} 
