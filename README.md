Pentru a realiza aceasta tema am creat urmatoarele clase:

- Clasa Trial:
    In aceasta clasa am chemat toate metodele necesare pentru a realiza taskul 1.
- Clasa OracleStuff:
    In aceasta clasa am implementat metodele din Clasa abstracta Task. De asemenea sunt definite 
  si toate variabilele de care voi avea nevoie pentru a rezolva acest task.
  - readProblemData:
    In aceasta metoda am citit inputul din _System.in_ si le-am salvat in ArrayListul de 
  ArrayListuri "clau" toate datele citite.
  - formulateOracleQuestion:
    In aceasta metoda am realizat transformarea si scrierea in fisierul "sat.cnf" a acesteia. 
  Inputul oracolului este format din patru "zone":
    - primul rand este format din stringul "p cnf", nr de variabile transformate si nr de clauze
    - a doua zona este formata din toate variabilele "noi", acestea sunt cate k pe linie, pana 
      la k*m
    - a treia zona este formata din taote aceste variabile, negate, combinate doua cate doua. 
    Deoarece variabilele de forma i + j*k reprezinta aceeasi variabila din inputul initial, 
    acestea nu se iau la combinatii pentru ca aceasta combinatie imi garanteaza maxim doua pe 
    coloana, lucru care nu este necesar. Restul combinatiilor imi garanteaza sa fie maxim k 
    clauze finale.
    - a patra zona este formata din toate variabilele de forma i+j*k care se afla pe randul 
    corespunztor randului din zona(de exemplu pe primul rand din aceasta zona se afla toate 
    clauzele din inputul original)
  - decipherOracleAnswer: In aceasta metoda citesc outputul oracolului aflat in fisierul "sat.
    sol" si il interpretez: salvez daca este true si in caz afirmativ salvez tot outputul 
    intr-un ArrayList si il sortez.
  - writeAnswer: In aceasta metoda scriu outputul interpretat la _System.Out_
  - setArrays: aceasta metoda este creata pentru a "seta" toate datele fara a le citi de la 
    _System.in_. Acest lucru este folosit la taskul 2 si 3.
- Clasa Rise: In aceasta clasa chem toate metodele necesare pentru a rezolva taskul.
- Clasa RiseStuff: 
   In aceasta clasa exista metodele necesare pentru rezolvarea taskului 2. De asemenea exista si 
  variabile pentru salvarea datelor.
    -  readProblemData: In aceasta metoda se afla citirea din _System.in_ a datelor problemei. 
       Datele acestui task sunt niste carti ce trebuie transformate in inputul taskului 1. 
       Aceste carti sunt adaugate intr-un hash map unde fiecarei carti de care este nevoie ii 
       este atribuita o valoare.
    - formulateOracleQuestion: In aceasta metoda trec datele din hash-map intr-o matrice (de 
      ArrayList-uri) exact la fel ca inputul de la taskul 1.
    - solve: In aceasta metoda chem functia de askOracle de la taskul 1 pentru un k de la 1 la 
      nr de deckrui. K final va fi primul k cu care rezultatul oracolului este "True".
    - decipherOracleAnswer: In aceasta metoda am realizat citirea din fisierul "sat.sol" si 
      "descifrarea" acestuia. Asemanator cu ce am facut la taskul 1.
    - writeAnswer: In aceasta metoda se scrie rezultatul in _System.out_