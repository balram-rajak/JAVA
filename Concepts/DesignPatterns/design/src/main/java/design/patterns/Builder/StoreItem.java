package design.patterns.Builder;

public class StoreItem {

    private final String itemName;
    private final float price;
    private final int id;

    public StoreItem(StoreItemBuilder builder){
        
        this.itemName = builder.itemName ;
        this.id = builder.id;
        this.price = builder.price;
    }

    public static final class StoreItemBuilder implements Builder<StoreItem>{
        
        private final String itemName;
        private float price;
        private int id;


        public StoreItemBuilder(String itemName){
            this.itemName =itemName;
        }

        public StoreItemBuilder price(float price){
            this.price = price;
            return this;
        }

        public StoreItemBuilder id(int id){
            this.id = id;
            return this;
        }
        
        @Override
        public StoreItem build(){
            return new StoreItem(this);
        }

    }

}
