using System;

class Program
{
    static void Main(string[] args)
    {
        var eye = Console.ReadLine();
        var mouse = Console.ReadLine();
        var face = String.Format("({0}{1}{0})/", eye, mouse);
        Console.WriteLine(face);
    }
}

