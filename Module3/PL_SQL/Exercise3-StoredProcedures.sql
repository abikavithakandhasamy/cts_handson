CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
   UPDATE Accounts
   SET Balance = Balance + (Balance * 0.01)
   WHERE AccountType = 'SAVINGS';

   COMMIT;

   DBMS_OUTPUT.PUT_LINE(
      'Monthly interest processed successfully.'
   );
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
   p_department_id NUMBER,
   p_bonus_percent NUMBER
)
AS
BEGIN
   UPDATE Employees
   SET Salary = Salary +
                (Salary * p_bonus_percent / 100)
   WHERE DepartmentID = p_department_id;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE(
      'Employee bonus updated successfully.'
   );
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds
(
   p_source_account NUMBER,
   p_target_account NUMBER,
   p_amount NUMBER
)
AS
   v_balance NUMBER;
BEGIN

   SELECT Balance
   INTO v_balance
   FROM Accounts
   WHERE AccountID = p_source_account;

   IF v_balance >= p_amount THEN

      UPDATE Accounts
      SET Balance = Balance - p_amount
      WHERE AccountID = p_source_account;

      UPDATE Accounts
      SET Balance = Balance + p_amount
      WHERE AccountID = p_target_account;

      COMMIT;

      DBMS_OUTPUT.PUT_LINE(
         'Fund Transfer Successful'
      );

   ELSE

      DBMS_OUTPUT.PUT_LINE(
         'Insufficient Balance'
      );

   END IF;

END;
/