#include <iostream>
using namespace std;
void swap(int a, int b)
{
    cout << "Before Swap"
         << "\n";
    cout << a << " " << b << "\n";
    int temp = a;
    a = b;
    b = temp;
    cout << "After Swap"
         << "\n";
    cout << a << " " << b << "\n";
}

void swap2(int *a, int *b)
{
    cout << "Before Swap"
         << "\n";
    cout << *a << " " << *b << "\n";
    int temp = *a;
    *a = *b;
    *b = temp;
    cout << "After Swap"
         << "\n";
    cout << *a << " " << *b << "\n";
}

void swap3(int *a, int *b)
{
    cout << "Before Swap" << endl;
    cout << *a << " " << *b << "\n";
    int temp = *a;
    *a = *b;
    *b = temp;
    cout << "After Swap" << endl;
    cout << *a << " " << *b << "\n";
}

void swap4(int **a, int **b)
{
    cout << "Before Swap" << endl;
    cout << **a << " " << **b << "\n";
    int *temp = *a;
    *a = *b;
    *b = temp;
    cout << "After Swap" << endl;
    cout << **a << " " << **b << "\n";
}

// void swap4(int **p1, int **p2)
// {
//     cout << "Before Swap" << endl;
//     cout << **p1 << " " << **p2 << "\n";
//     int* temp = *p1;
//     *p1 = *p2;
//     *p2 = *temp;
//     cout << "After Swap" << endl;
//     cout << **p1 << " " << **p2 << "\n";
// }

int main()
{
    int a = 10;
    int b = 20;
    // value types - call by value
    // swap(a, b);
    // value types - call by reference
    // swap2(&a, &b);

    // Reference type - call by value
    // int *r1 = &a;
    // int *r2 = &b;
    // swap3(r1, r2);

    // Reference type - call by reference
    int *r1 = &a;
    int *r2 = &b;
    swap4(&r1, &r2);
    cout << "Swapped Address Values Before" << endl;
    cout << *r1 << " " << *r2 << "\n";
    cout << "Main Value" << endl;
    cout << a << " " << b << "\n";
    cout << "Swapped Address Values After" << endl;
    cout << *r1 << " " << *r2 << "\n";
    return 0;
}