BEGIN
   FOR cust IN (
      SELECT CustomerID, Age
      FROM Customers
      WHERE Age > 60
   )
   LOOP
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;

      DBMS_OUTPUT.PUT_LINE(
         'Discount applied for Customer ID: '
         || cust.CustomerID
      );
   END LOOP;

   COMMIT;
END;
/

BEGIN
   FOR cust IN (
      SELECT CustomerID, Balance
      FROM Customers
      WHERE Balance > 10000
   )
   LOOP
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust.CustomerID;

      DBMS_OUTPUT.PUT_LINE(
         'VIP Status Updated for Customer ID: '
         || cust.CustomerID
      );
   END LOOP;

   COMMIT;
END;
/

BEGIN
   FOR loan_rec IN (
      SELECT LoanID,
             CustomerID,
             DueDate
      FROM Loans
      WHERE DueDate BETWEEN SYSDATE
            AND SYSDATE + 30
   )
   LOOP
      DBMS_OUTPUT.PUT_LINE(
         'Reminder: Loan '
         || loan_rec.LoanID
         || ' for Customer '
         || loan_rec.CustomerID
         || ' is due on '
         || loan_rec.DueDate
      );
   END LOOP;
END;
/