public class ExampleLinkedList<T> {
    private Link<T> firstElem;
    private Link<T> lastElem;

    public ExampleLinkedList() {
        this.firstElem = null;
        this.lastElem = null;
    }

    public Link<T> getFirstElem() {
        return firstElem;
    }

    public Link<T> getLastElem() {
        return lastElem;
    }

    public boolean isEmpty() {
        return (firstElem == null);
    }

    public void addFirst(T elem) {
        Link<T> newElem = new Link<>(elem);
        newElem.setNext(firstElem);
        this.firstElem = newElem;

        if (lastElem == null) {
            this.lastElem = newElem;
        }
    }

    public void addLast(T elem) {
        Link<T> newElem = new Link<>(elem);
        if (lastElem != null) {
            lastElem.setNext(newElem);
            this.lastElem = newElem;
        } else {
            this.lastElem = newElem;
            this.firstElem = newElem;
        }
    }

    public void info() {
        Link<T> current = firstElem;
        System.out.println(current);
        while (current.hasNext()) {
            System.out.println(current.getNextElem());
            current = current.getNextElem();
        }
    }

    public Link<T> delete() {
        Link<T> tmp = firstElem;
        firstElem = firstElem.getNextElem();
        return tmp;
    }


    class Link<T> {
        private T link;
        private Link<T> nextElem;

        public Link(T link) {
            this.link = link;
            this.nextElem = null;
        }

        public void setNext(Link<T> nextLink) {
            this.nextElem = nextLink;
        }

        public T getLink() {
            return link;
        }

        public Link<T> getNextElem() {
            return nextElem;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "link=" + link +
                    '}';
        }

        public boolean hasNext() {
            return !(nextElem == null);
        }
    }

}

