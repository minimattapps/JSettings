JSettings
=========

A simple and easy to use Settings Library for Java

How to Use:

Download the JSettings.java file and add it to your project

You can now use JSettings by adding the following code

JSettings s = new JSettings(System.getProperty("user.home") + "/jsettings.config");
*Change Location of File to Suit your needs

Now you have access to JSettings

To Add a Value just use

s.SetValue("Location","Value");

Example:

s.SetValue("IsJSettingsCool","YES");

To Read a Value just use

s.GetValue("Location");

Example: 

System.out.println(s.GetValue("IsJSettingsCool"));

And one Last thing.....

To Clear the Settings just call

s.ClearSettings();

Thats It Have Fun Using JSettings in your application.





LICENSE:

There is none. You can do whatever you want with this code.
Change it, Sell it,Include it in your Commerical Project
Do anything you want with it i don't care