public final class ImmutableClass {
    private final int id;
    private final String name;
    private final MutableClass mutableObject;

    public static class MutableClass {
        private int id;
        private String name;

        MutableClass(int id, String name) {
            this.id = id;
            this.name = name;
        }

        MutableClass(MutableClass other) {
            this.id = other.id;
            this.name = other.name;
        }

        public int getId() {
            return id;
        }

        public void setId(int value) {
            id = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String value) {
            name = value;
        }

        @Override
        public String toString() {
            return String.format("[ID = %s, Name = %s]", id, name);
        }
    }

    ImmutableClass(int id, String name, MutableClass mutableObject) {
        this.id = id;
        this.name = name;
        this.mutableObject = new MutableClass(mutableObject);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MutableClass getMutableObject() {
        return new MutableClass(mutableObject);
    }
}