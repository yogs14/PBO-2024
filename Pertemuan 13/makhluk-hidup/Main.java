// Abstract class MakhlukHidup
abstract class MakhlukHidup {
    // Abstract method
    abstract void bernafas();
    
    // Concrete method
    void makan() {
        System.out.println("Makhluk hidup sedang makan.");
    }
}

// Subclass Manusia
class Manusia extends MakhlukHidup {
    @Override
    void bernafas() {
        System.out.println("Manusia bernafas dengan paru-paru.");
    }
}

// Subclass Hewan
class Hewan extends MakhlukHidup {
    @Override
    void bernafas() {
        System.out.println("Hewan bernafas dengan paru-paru atau insang.");
    }
}

// Subclass Tumbuhan
class Tumbuhan extends MakhlukHidup {
    @Override
    void bernafas() {
        System.out.println("Tumbuhan bernafas melalui stomata.");
    }
}

// Main class untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();
        
        manusia.bernafas();
        manusia.makan();
        
        hewan.bernafas();
        hewan.makan();
        
        tumbuhan.bernafas();
        tumbuhan.makan();
    }
}
