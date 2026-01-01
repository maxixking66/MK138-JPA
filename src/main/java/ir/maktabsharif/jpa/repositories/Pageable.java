package ir.maktabsharif.jpa.repositories;

public interface Pageable {

    int size();

    int page();

    default int offset() {
        return size() * page();
    }

    static Pageable defaultPage() {
        return new Pageable() {
            @Override
            public int size() {
                return 5;
            }

            @Override
            public int page() {
                return 0;
            }
        };
    }
}
