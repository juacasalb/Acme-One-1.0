package acme.testing;

import org.hibernate.internal.util.StringHelper;

import acme.framework.testing.AbstractTest;

public abstract class TestHarness extends AbstractTest {
	
	// Business methods -------------------------------------------------------
	
	protected void signIn(final String username, final String password) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		
		super.navigateHome();
		super.clickOnMenu("Sign in");
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("remember", "true");
		super.clickOnSubmit("Sign in");
		super.checkCurrentPath("/master/welcome");
		super.checkLinkExists("Account");
	}

	protected void signOut() {
		super.navigateHome();
		super.clickOnMenu("Sign out");
		super.checkCurrentPath("/master/welcome");
		super.checkNotLinkExists("Account");
	}

	protected void signUp(final String username, final String password, final String name, final String surname, final String email) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		assert !StringHelper.isBlank(name);
		assert !StringHelper.isBlank(surname);
		assert !StringHelper.isBlank(email);

		super.navigateHome();
		super.clickOnMenu("Sign up");	
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);		
		super.fillInputBoxIn("accept", "true");
		super.clickOnSubmit("Sign up");
		super.checkCurrentPath("/master/welcome");
		super.checkNotLinkExists("Account");
	}

}