public final class ImmutableClass {
    private final int id;
    private final String name;
    private final MutableClass mutableObject;

    @Override
    public String toString() {
        return "ImmutableObject = [ " +
                "id = " + getId() +
                ", name = \"" + getName() + '"' +
                ", mutableObject = " + getMutableObject() +
                " ]";
    }

    public static class MutableClass implements Cloneable {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public MutableClass(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("[ id = %s, name = \"%s\" ]", id, name);
        }

        @Override
        public MutableClass clone() {
            try {
                return (MutableClass) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("CloneNotSupportedException", e);
            }
        }
    }

    ImmutableClass(int id, String name, MutableClass mutableObject) {
        this.id = id;
        this.name = name;
        if (mutableObject == null)
            throw new IllegalArgumentException("mutableObject is null");
        this.mutableObject = mutableObject.clone();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MutableClass getMutableObject() {
        return mutableObject.clone();
    }
}