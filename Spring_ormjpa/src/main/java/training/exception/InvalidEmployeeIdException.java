package training.exception;


@SuppressWarnings("Serial")
public class InvalidEmployeeIdException extends Exception {
	
	public InvalidEmployeeIdException()
	{
		super("Entered Employee Id doesn't exist, Please give a valid employeeId");
	}

}