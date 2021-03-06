package org.activiti.designer.property;

import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.TimerEventDefinition;
import org.activiti.bpmn.model.alfresco.AlfrescoStartEvent;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class PropertyTimerStartEventFilter extends ActivitiPropertyFilter {
	
	@Override
	protected boolean accept(PictogramElement pe) {
		Object bo = getBusinessObject(pe);
		if (bo instanceof StartEvent && bo instanceof AlfrescoStartEvent == false) {
			if (((StartEvent) bo).getEventDefinitions().size() > 0) {
				if(((StartEvent) bo).getEventDefinitions().get(0) instanceof TimerEventDefinition) {
					return true;
				}
			}
		}
		return false;
	}

}
