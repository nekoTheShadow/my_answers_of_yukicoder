using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


class Person
{
    private char name;
    private int height;
    private int weight;

    public Person(char name, int height, int weight)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public char Name { get {return this.name; }}
    public int Height { get { return this.height; } }
    public int Weight { get { return this.weight; } }

}

class Program
{
    static void Main(string[] args)
    {
        var persons = new List<Person>();
        for (char name = 'A'; ; name++)
        {
            var line = Console.ReadLine();
            if (line == null) break;

            var tokens = line.Split(' ').Select(int.Parse).ToArray();
            persons.Add(new Person(name, tokens[0], tokens[1]));
        }

        var sortedPersons = persons.OrderByDescending((person) => person.Height).ThenBy((person) => person.Weight);
        foreach (var person in sortedPersons) Console.WriteLine(person.Name);
    }
}
