/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.rrm.ehour.ui.report.panel.aggregate;

import net.rrm.ehour.service.report.reports.ReportData;
import net.rrm.ehour.ui.common.report.ReportConfig;
import net.rrm.ehour.ui.report.TreeReport;
import net.rrm.ehour.ui.report.TreeReportData;
import net.rrm.ehour.ui.report.chart.AggregateChartDataConverter;
import net.rrm.ehour.ui.report.chart.aggregate.AggregateChartImage;
import net.rrm.ehour.ui.report.chart.aggregate.UserHoursAggregateChartDataConverter;
import net.rrm.ehour.ui.report.chart.aggregate.UserTurnoverAggregateChartDataConverter;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.Model;

public class EmployeeReportPanel extends AggregateReportPanel
{
	private static final long serialVersionUID = 2594554714722639450L;

	public EmployeeReportPanel(String id, TreeReport report)
	{
		super(id, report, ReportConfig.AGGREGATE_EMPLOYEE, EmployeeReportExcel.getId());
	}	

	@Override
	protected void addCharts(String hourId, String turnOverId, ReportData data, WebMarkupContainer parent)
	{
		ReportData rawData = ((TreeReportData)data).getRawReportData();
		Model<ReportData> dataModel = new Model<ReportData>(rawData);
		
		AggregateChartDataConverter hourConverter = new UserHoursAggregateChartDataConverter();
		Image customerHoursChart = new AggregateChartImage(hourId, dataModel, getChartWidth().getValue(), getChartHeight().getValue(), hourConverter);
		parent.add(customerHoursChart);

		AggregateChartDataConverter turnoverConverter = new UserTurnoverAggregateChartDataConverter();
		Image customerTurnoverChart = new AggregateChartImage(turnOverId, dataModel, getChartWidth().getValue(), getChartHeight().getValue(), turnoverConverter);
		parent.add(customerTurnoverChart);
	}
}
