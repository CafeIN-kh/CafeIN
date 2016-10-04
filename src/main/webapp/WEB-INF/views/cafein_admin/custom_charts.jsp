<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section id="content">
	<div class="container">
		<div class="block-header">
			<h2>
				Flot Charts <small>Flot is a pure JavaScript plotting
					library for jQuery, with a focus on simple usage, attractive looks
					and interactive features.</small>
			</h2>

		</div>
		<div class="col-md-12">
			<div class="dash-widgets">
				<div class="row">
					<div class="col-md-6" style="padding-left:0px">
						<div id="site-visits" class="dash-widget-item bgm-teal">
							<div class="dash-widget-header">
								<div class="p-20">
									<div class="dash-widget-visits"></div>
								</div>

								<div class="dash-widget-title">일주일간 Page View</div>

								<ul class="actions actions-alt">
									<li class="dropdown"><a href="" data-toggle="dropdown">
											<i class="md md-more-vert"></i>
									</a>

										<ul class="dropdown-menu dropdown-menu-right">
											<li><a href="">Refresh</a></li>
											<li><a href="">Manage Widgets</a></li>
											<li><a href="">Widgets Settings</a></li>
										</ul></li>
								</ul>
							</div>

							<div class="p-20">

								<small>Page Views</small>
								<h3 class="m-0 f-400" id="cpvCount"></h3>

							
							</div>
						</div>
					</div>
					<div class="col-md-6" style="padding-right:0px">
						<div id="site-visits" class="dash-widget-item bgm-teal">
							<div class="dash-widget-header">
								<div class="p-20">
									<div class="dash-widget-visits1"></div>
								</div>

								<div class="dash-widget-title">일주일간 신고 횟수</div>

								<ul class="actions actions-alt">
									<li class="dropdown"><a href="" data-toggle="dropdown">
											<i class="md md-more-vert"></i>
									</a>

										<ul class="dropdown-menu dropdown-menu-right">
											<li><a href="">Refresh</a></li>
											<li><a href="">Manage Widgets</a></li>
											<li><a href="">Widgets Settings</a></li>
										</ul></li>
								</ul>
							</div>

							<div class="p-20">

								<small>Page Views</small>
								<h3 class="m-0 f-400" id="cdcCount">47,896,536</h3>

								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Custom Like Day Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart" class="flot-chart"></div>
						
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Custom Like Month Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart2" class="flot-chart"></div>
						
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Custom BookMark Day Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart3" class="flot-chart"></div>
						
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Custom BookMark Month Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart4" class="flot-chart"></div>
						
					</div>
				</div>
			</div>
<!-- 
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Bar Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart2" class="flot-chart"></div>
						<div class="flc-bar"></div>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Bar Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart3" class="flot-chart"></div>
						<div class="flc-bar"></div>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h2>Bar Chart</h2>

						<ul class="actions">
							<li class="dropdown action-show"><a href=""
								data-toggle="dropdown"> <i class="md md-more-vert"></i>
							</a>

								<div class="dropdown-menu pull-right">
									<p class="p-20">You can put anything here</p>
								</div></li>
						</ul>
					</div>

					<div class="card-body card-padding-sm">
						<div id="bar-chart4" class="flot-chart"></div>
						<div class="flc-bar"></div>
					</div>
				</div>
			</div> -->


		</div>
	</div>
</section>