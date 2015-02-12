# AnimImageView
Android custom view for showing animationdrawable

## Quick Start
Add the AnimImageView in the layout.xml like this:

	<com.jackoder.widget.AnimImageView
		xmlns:aiv="http://schemas.android.com/apk/res-auto"
		android:id="@+id/aiv_loading"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:src="@drawable/empty_loading"
		aiv:aiv_auto="false"/>

**Tips**: The **aiv_auto** is to configure whether the animation will start by itself. The default is true.

##Maybe Useful
AnimImageView also provides some method for manual control:


	//restart is false
	void startAnimation()

	void startAnimation(boolean restart)

	void stopAnimation()

##
I'm glad to have you good idea for this. My email is jackoder@qq.com. 

