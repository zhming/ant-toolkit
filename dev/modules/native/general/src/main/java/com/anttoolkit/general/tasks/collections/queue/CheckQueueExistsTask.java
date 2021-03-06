package com.anttoolkit.general.tasks.collections.queue;

import org.apache.tools.ant.*;

import com.anttoolkit.general.tasks.*;
import com.anttoolkit.general.tasks.collections.queue.util.*;

public class CheckQueueExistsTask extends GenericTask
{
	private String queueName = null;
	private String property = null;

	public void setQueue(String name)
	{
		queueName = name;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public void doWork() throws BuildException
	{
		setPropertyThreadSafe(property, Boolean.toString(QueueManager.exists(queueName)));
	}

	protected void validate()
	{
		if (queueName == null)
		{
			throw new BuildException("Queue name should be specified");
		}

		if (property == null)
		{
			throw new BuildException("Ant property name should be specified");
		}
	}
}
