package uz.indicator.db.dao.Interfaces;

import uz.indicator.collections.ObjectAndMessage;
import uz.indicator.db.entities.documents.Payment;
import uz.indicator.db.enums.PaymentType;


import java.util.List;

public interface PaymentDAO {

    List<Payment> getAllAvailablePayments();
    List<Payment> getAllDeletedPayments();
    List<Payment> getAllPaymentsForPayer(int payerId);
    List<Payment> filterByPaymentType(PaymentType paymentType);
    List<Payment> calculateSumForAllInstances();
    Payment getLastPaymentForUser(int payerId);

    ObjectAndMessage acceptPayment(Payment payment);
    double getAllPaymentsForOnePayer(int payerId);
    String deletePayment(int paymentId);

}
