package hello.core.order;

public interface OrderService { //서비스 단계 interface
    Order createOrder(Long memberId, String itemName, int itemPrice); //주문
}
